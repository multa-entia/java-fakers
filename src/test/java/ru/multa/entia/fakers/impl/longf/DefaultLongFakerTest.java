package ru.multa.entia.fakers.impl.longf;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultLongFakerTest {

    @RepeatedTest(1_000)
    void shouldCheckRandomMethod() {
        Long random = new DefaultLongFaker().random();
        assertThat(random).isNotNull();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "shouldCheckBetweenMethod.csv")
    void shouldCheckBetweenMethod(long min, long max, long minBorder, long maxBorder) {
        Long result = new DefaultLongFaker().between(min, max);
        assertThat(result).isGreaterThanOrEqualTo(minBorder);
        assertThat(result).isLessThanOrEqualTo(maxBorder);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "shouldCheckGreaterMethod.csv")
    void shouldCheckGreaterMethod(long threshold, long minBorder, long maxBorder) {
        Long result = new DefaultLongFaker().greater(threshold);
        assertThat(result).isGreaterThanOrEqualTo(minBorder);
        assertThat(result).isLessThanOrEqualTo(maxBorder);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "shouldCheckGreaterOrEqualMethod.csv")
    void shouldCheckGreaterOrEqualMethod(long threshold, long minBorder, long maxBorder) {
        Long result = new DefaultLongFaker().greaterOrEqual(threshold);
        assertThat(result).isGreaterThanOrEqualTo(minBorder);
        assertThat(result).isLessThanOrEqualTo(maxBorder);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "shouldCheckLessMethod.csv")
    void shouldCheckLessMethod(long threshold, long minBorder, long maxBorder) {
        Long result = new DefaultLongFaker().less(threshold);
        assertThat(result).isGreaterThanOrEqualTo(minBorder);
        assertThat(result).isLessThanOrEqualTo(maxBorder);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "shouldCheckLessOrEqualMethod.csv")
    void shouldCheckLessOrEqualMethod(long threshold, long minBorder, long maxBorder) {
        Long result = new DefaultLongFaker().lessOrEqual(threshold);
        assertThat(result).isGreaterThanOrEqualTo(minBorder);
        assertThat(result).isLessThanOrEqualTo(maxBorder);
    }
}