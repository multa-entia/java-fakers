package ru.multa.entia.fakers.impl.longf;

import com.github.javafaker.Faker;
import ru.multa.entia.fakers.api.longf.LongFaker;

public class DefaultLongFaker implements LongFaker {
    private final Faker faker = new Faker();

    @Override
    public Long random(final Object... args) {
        return faker.number().randomNumber();
    }

    @Override
    public Long between(final Long min, final Long max) {
        return faker.number().numberBetween(min, max < min ? min : max);
    }

    @Override
    public Long greater(final Long threshold) {
        return threshold.equals(Long.MAX_VALUE)
                ? threshold
                : faker.number().numberBetween(threshold+1, Long.MAX_VALUE);
    }

    @Override
    public Long greaterOrEqual(final Long threshold) {
        return threshold.equals(Long.MAX_VALUE)
                ? threshold
                : faker.number().numberBetween(threshold, Long.MAX_VALUE);
    }

    @Override
    public Long less(final Long threshold) {
        return threshold.equals(Long.MIN_VALUE)
                ? threshold
                : faker.number().numberBetween(Long.MIN_VALUE, threshold);
    }

    @Override
    public Long lessOrEqual(final Long threshold) {
        return threshold.equals(Long.MIN_VALUE)
                ? threshold
                : faker.number().numberBetween(Long.MIN_VALUE, threshold+1);
    }
}
