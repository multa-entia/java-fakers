package ru.multa.entia.fakers.impl.uuidf;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class DefaultUuidFakerTest {


    @Test
    void shouldCheckRandomMethod() {
        UUID uuid = new DefaultUuidFaker().random();
        Assertions.assertThat(uuid).isNotNull();
    }
}