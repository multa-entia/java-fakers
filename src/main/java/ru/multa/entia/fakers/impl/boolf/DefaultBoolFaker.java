package ru.multa.entia.fakers.impl.boolf;

import com.github.javafaker.Faker;
import ru.multa.entia.fakers.api.boolf.BoolFaker;

public class DefaultBoolFaker implements BoolFaker {
    private final Faker faker = new Faker();

    @Override
    public Boolean random(final Object... args) {
        return faker.number().randomDigit() % 2 == 0;
    }
}
