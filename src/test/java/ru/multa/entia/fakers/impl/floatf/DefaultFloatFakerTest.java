package ru.multa.entia.fakers.impl.floatf;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultFloatFakerTest {

    @Test
    void shouldCheckRandom() {
        HashMap<Float, Integer> counters = new HashMap<>();
        DefaultFloatFaker faker = new DefaultFloatFaker();
        for (int i = 0; i < 1_000; i++) {
            Float value = faker.random();
            assertThat(value).isNotNull();
            counters.put(value, counters.containsKey(value) ? counters.get(value) + 1 : 1);
        }

        AtomicBoolean result = new AtomicBoolean(true);
        counters.forEach((key, value) -> {
            System.out.println(key);
            if (value > 1) {
                result.set(false);
            }
        });
        assertThat(result.get()).isTrue();
    }

    // TODO: del
//    @Test
//    void name() {
//        BigDecimal decimal = new BigDecimal("123");
//        for (int i = -10; i <= 10; i++) {
//            System.out.println(i + " : " + decimal.setScale(i, RoundingMode.UP).floatValue());
//        }
//    }
}