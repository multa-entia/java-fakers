package ru.multa.entia.fakers.impl.doublef;

import com.github.javafaker.Faker;
import ru.multa.entia.fakers.api.doublef.DoubleFaker;

public class DefaultDoubleFaker implements DoubleFaker {
    private static final double DEFAULT_MIN = (double) Long.MIN_VALUE;
    private static final double DEFAULT_MAX = (double) Long.MAX_VALUE;
    private static final int MIN_DEPTH = 1;
    private static final int DEFAULT_DEPTH = 5;
    private static final int MAX_DEPTH = 10;
    private static final int DEFAULT_PART_SIZE = 100;

    private final Faker faker = new Faker();

    @Override
    public Double random(final Object... args) {
        double min = DEFAULT_MIN;
        double max = DEFAULT_MAX;
        int depth = DEFAULT_DEPTH;
        if (args.length == 3 && args[0].getClass().equals(Double.class) &&
                args[1].getClass().equals(Double.class) && args[2].getClass().equals(Integer.class)){
            min = Math.min((double) args[0], (double) args[1]);
            max = Math.max((double) args[0], (double) args[1]);
            depth = Math.max(MIN_DEPTH, (int) args[2]);
            depth = Math.min(MAX_DEPTH, depth);
        }

        return compute(min, max - min, depth);
    }

    @Override
    public Double between(final Double min, final Double max) {
        double trueMin = Math.min(min, max);
        double trueMax = Math.max(min, max);

        return compute(trueMin, trueMax - trueMin, DEFAULT_PART_SIZE);
    }

    @Override
    public Double greater(final Double threshold) {
        return compute(threshold, (double) Long.MAX_VALUE - threshold, DEFAULT_PART_SIZE);
    }

    @Override
    public Double greaterOrEqual(final Double threshold) {
        return compute(threshold, (double) Long.MAX_VALUE - threshold, DEFAULT_PART_SIZE);
    }

    @Override
    public Double less(final Double threshold) {
        return compute((double) Long.MIN_VALUE, threshold - (double) Long.MIN_VALUE, DEFAULT_PART_SIZE);
    }

    @Override
    public Double lessOrEqual(final Double threshold) {
        return compute((double) Long.MIN_VALUE, threshold - (double) Long.MIN_VALUE, DEFAULT_PART_SIZE);
    }

    private double compute(double base, double range, int depth) {
        double newRange = range / DEFAULT_PART_SIZE;
        double tail = newRange * (double) faker.number().numberBetween(0, DEFAULT_PART_SIZE);
        base += tail;
        return --depth > 0 ? compute(base, newRange, depth) : base;
    }
}
