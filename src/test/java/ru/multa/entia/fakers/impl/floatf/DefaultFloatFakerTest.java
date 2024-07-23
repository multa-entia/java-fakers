package ru.multa.entia.fakers.impl.floatf;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

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
            if (value > 1) {
                result.set(false);
            }
        });
        assertThat(result.get()).isTrue();
    }

    @RepeatedTest(1_000)
    void shouldCheckBetween() {
        float min = 123.456f;
        float max = 456.789f;
        Float result = new DefaultFloatFaker().between(min, max);

        assertThat(result).isGreaterThanOrEqualTo(min);
        assertThat(result).isLessThanOrEqualTo(max);
    }

    @RepeatedTest(1_000)
    void shouldCheckGreater() {
        float threshold = 123.456f;
        Float result = new DefaultFloatFaker().greater(threshold);

        assertThat(result).isGreaterThan(threshold);
    }

    @RepeatedTest(1_000)
    void shouldCheckGreaterOrEqual() {
        float threshold = 123.456f;
        Float result = new DefaultFloatFaker().greaterOrEqual(threshold);

        assertThat(result).isGreaterThanOrEqualTo(threshold);
    }

    @RepeatedTest(1_000)
    void shouldCheckLess() {
        float threshold = 123.456f;
        Float result = new DefaultFloatFaker().less(threshold);

        assertThat(result).isLessThan(threshold);
    }

    @RepeatedTest(1_000)
    void shouldCheckLessOrEqual() {
        float threshold = 123.456f;
        Float result = new DefaultFloatFaker().lessOrEqual(threshold);

        assertThat(result).isLessThanOrEqualTo(threshold);
    }
}