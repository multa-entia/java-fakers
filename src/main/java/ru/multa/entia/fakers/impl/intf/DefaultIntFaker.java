package ru.multa.entia.fakers.impl.intf;

import com.github.javafaker.Faker;
import ru.multa.entia.fakers.api.intf.IntFaker;

public class DefaultIntFaker implements IntFaker {
    private final Faker faker = new Faker();

    @Override
    public Integer random() {
        return faker.number().randomDigit();
    }

    @Override
    public Integer between(Integer min, Integer max) {
        return faker.number().numberBetween(min, max < min ? min : max);
    }

    @Override
    public Integer greater(Integer threshold) {
        return threshold.equals(Integer.MAX_VALUE)
                ? threshold
                : faker.number().numberBetween(threshold+1, Integer.MAX_VALUE);
    }

    @Override
    public Integer greaterOrEqual(Integer threshold) {
        return threshold.equals(Integer.MAX_VALUE)
                ? threshold
                : faker.number().numberBetween(threshold, Integer.MAX_VALUE);
    }

    @Override
    public Integer less(Integer threshold) {
        return threshold.equals(Integer.MIN_VALUE)
                ? threshold
                : faker.number().numberBetween(Integer.MIN_VALUE, threshold);
    }

    @Override
    public Integer lessOrEqual(Integer threshold) {
        return threshold.equals(Integer.MIN_VALUE)
                ? threshold
                : faker.number().numberBetween(Integer.MIN_VALUE, threshold+1);
    }
}
