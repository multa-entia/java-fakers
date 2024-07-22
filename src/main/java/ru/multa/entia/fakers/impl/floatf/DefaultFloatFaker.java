package ru.multa.entia.fakers.impl.floatf;

import com.github.javafaker.Faker;
import ru.multa.entia.fakers.api.floatf.FloatFaker;

import java.math.BigDecimal;

public class DefaultFloatFaker implements FloatFaker {
    private static final int MIN_SCALE = 0;
    private static final int MAX_SCALE = 30;

    private final Faker faker = new Faker();

    @Override
    public Float random(final Object... args) {
        float range = (float) Long.MAX_VALUE - (float) Long.MIN_VALUE;
        float chunkCount = (float) Math.sqrt(Math.abs(range));
        long randomChunk = faker.random().nextLong((long) chunkCount);
        float chunkStart = (float) Long.MIN_VALUE + (float) randomChunk * chunkCount;
        float adj = chunkStart * (float) faker.random().nextInt(Integer.MAX_VALUE);

        return new BigDecimal(chunkStart + adj).floatValue() / (float) Math.pow(10.0f, faker.random().nextInt(MIN_SCALE, MAX_SCALE));
    }

    @Override
    public Float between(final Float min, final Float max) {
        throw new RuntimeException("between");
        // TODO: !!!
//        return 0f;
    }

    @Override
    public Float greater(final Float threshold) {
        throw new RuntimeException("greater");
        // TODO: !!!
//        return 0f;
    }

    @Override
    public Float greaterOrEqual(final Float threshold) {
        throw new RuntimeException("greaterOrEqual");
        // TODO: !!!
//        return 0f;
    }

    @Override
    public Float less(final Float threshold) {
        throw new RuntimeException("less");
        // TODO: !!!
//        return 0f;
    }

    @Override
    public Float lessOrEqual(final Float threshold) {
        throw new RuntimeException("lessOrEqual");
        // TODO: !!!
//        return 0f;
    }
}
