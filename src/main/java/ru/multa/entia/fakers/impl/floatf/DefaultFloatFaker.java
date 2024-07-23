package ru.multa.entia.fakers.impl.floatf;

import com.github.javafaker.Faker;
import ru.multa.entia.fakers.api.floatf.FloatFaker;

public class DefaultFloatFaker implements FloatFaker {
    private static final float DEFAULT_MIN = (float) Long.MIN_VALUE;
    private static final float DEFAULT_MAX = (float) Long.MAX_VALUE;
    private static final int MIN_DEPTH = 1;
    private static final int DEFAULT_DEPTH = 5;
    private static final int MAX_DEPTH = 10;
    private static final int DEFAULT_PART_SIZE = 100;

    private final Faker faker = new Faker();

    @Override
    public Float random(final Object... args) {
        float min = DEFAULT_MIN;
        float max = DEFAULT_MAX;
        int depth = DEFAULT_DEPTH;
        if (args.length == 3 && args[0].getClass().equals(Float.class) &&
                args[1].getClass().equals(Float.class) && args[2].getClass().equals(Integer.class)){
            min = Math.min((float) args[0], (float) args[1]);
            max = Math.max((float) args[0], (float) args[1]);
            depth = Math.max(MIN_DEPTH, (int) args[2]);
            depth = Math.min(MAX_DEPTH, depth);
        }

        return compute(min, max - min, depth);
    }

    @Override
    public Float between(final Float min, final Float max) {
        float trueMin = Math.min(min, max);
        float trueMax = Math.max(min, max);

        return compute(trueMin, trueMax - trueMin, DEFAULT_PART_SIZE);
    }

    @Override
    public Float greater(final Float threshold) {
        return compute(threshold, (float) Long.MAX_VALUE - threshold, DEFAULT_PART_SIZE);
    }

    @Override
    public Float greaterOrEqual(final Float threshold) {
        return compute(threshold, (float) Long.MAX_VALUE - threshold, DEFAULT_PART_SIZE);
    }

    @Override
    public Float less(final Float threshold) {
        return compute((float) Long.MIN_VALUE, threshold - (float) Long.MIN_VALUE, DEFAULT_PART_SIZE);
    }

    @Override
    public Float lessOrEqual(final Float threshold) {
        return compute((float) Long.MIN_VALUE, threshold - (float) Long.MIN_VALUE, DEFAULT_PART_SIZE);
    }

    private Float compute(float base, float range, int depth) {
        float newRange = range / DEFAULT_PART_SIZE;
        int steps = faker.number().numberBetween(0, DEFAULT_PART_SIZE);
        float tail = newRange * (float) steps;
        float b =  base + tail;
        return --depth > 0 ? compute(b, newRange, depth) : b;
    }
}
