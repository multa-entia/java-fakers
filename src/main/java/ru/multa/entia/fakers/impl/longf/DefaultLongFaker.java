package ru.multa.entia.fakers.impl.longf;

import com.github.javafaker.Faker;
import ru.multa.entia.fakers.api.longf.LongFaker;

public class DefaultLongFaker implements LongFaker {
    private final Faker faker = new Faker();

    @Override
    public Long random(Object... args) {
        return faker.number().randomNumber();
    }

    @Override
    public Long between(Long min, Long max) {
        return faker.number().numberBetween(min, max < min ? min : max);
    }

    @Override
    public Long greater(Long threshold) {
        return threshold.equals(Long.MAX_VALUE)
                ? threshold
                : faker.number().numberBetween(threshold+1, Long.MAX_VALUE);
    }

    @Override
    public Long greaterOrEqual(Long threshold) {
        return threshold.equals(Long.MAX_VALUE)
                ? threshold
                : faker.number().numberBetween(threshold, Long.MAX_VALUE);
    }

    @Override
    public Long less(Long threshold) {
        return threshold.equals(Long.MIN_VALUE)
                ? threshold
                : faker.number().numberBetween(Long.MIN_VALUE, threshold);
    }

    @Override
    public Long lessOrEqual(Long threshold) {
        return threshold.equals(Long.MIN_VALUE)
                ? threshold
                : faker.number().numberBetween(Long.MIN_VALUE, threshold+1);
    }
}
