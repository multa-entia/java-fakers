package ru.multa.entia.fakers.impl.uuidf;

import com.github.javafaker.Faker;
import ru.multa.entia.fakers.api.uuidf.UuidFaker;

import java.util.UUID;

public class DefaultUuidFaker implements UuidFaker {
    private final Faker faker = new Faker();

    @Override
    public UUID random(Object... args) {
        return UUID.randomUUID();
    }
}
