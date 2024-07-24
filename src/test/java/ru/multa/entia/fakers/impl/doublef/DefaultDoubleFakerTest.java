package ru.multa.entia.fakers.impl.doublef;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultDoubleFakerTest {

    @Test
    void shouldCheckRandom() {
        HashMap<Double, Integer> counters = new HashMap<>();
        DefaultDoubleFaker faker = new DefaultDoubleFaker();
        for (int i = 0; i < 1_000; i++) {
            double value = faker.random();
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
        double min = 123.456;
        double max = 456.789;
        double result = new DefaultDoubleFaker().between(min, max);

        assertThat(result).isGreaterThanOrEqualTo(min);
        assertThat(result).isLessThanOrEqualTo(max);
    }

    @RepeatedTest(1_000)
    void shouldCheckGreater() {
        double threshold = 123.456;
        double result = new DefaultDoubleFaker().greater(threshold);

        assertThat(result).isGreaterThan(threshold);
    }

    @RepeatedTest(1_000)
    void shouldCheckGreaterOrEqual() {
        double threshold = 123.456;
        double result = new DefaultDoubleFaker().greaterOrEqual(threshold);

        assertThat(result).isGreaterThanOrEqualTo(threshold);
    }

    @RepeatedTest(1_000)
    void shouldCheckLess() {
        double threshold = 123.456;
        double result = new DefaultDoubleFaker().less(threshold);

        assertThat(result).isLessThan(threshold);
    }

    @RepeatedTest(1_000)
    void shouldCheckLessOrEqual() {
        double threshold = 123.456;
        double result = new DefaultDoubleFaker().lessOrEqual(threshold);

        assertThat(result).isLessThanOrEqualTo(threshold);
    }
}