package ru.multa.entia.fakers.impl.intf;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultIntFakerTest {

    @RepeatedTest(1_000)
    void shouldCheckRandomMethod() {
        Integer result = new DefaultIntFaker().random();
        assertThat(result).isNotNull();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "shouldCheckBetweenMethod.csv")
    void shouldCheckBetweenMethod(int min, int max, int minBorder, int maxBorder) {
        Integer result = new DefaultIntFaker().between(min, max);
        assertThat(result).isGreaterThanOrEqualTo(minBorder);
        assertThat(result).isLessThanOrEqualTo(maxBorder);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "shouldCheckGreaterMethod.csv")
    void shouldCheckGreaterMethod(int threshold, int minBorder, int maxBorder) {
        Integer result = new DefaultIntFaker().greater(threshold);
        assertThat(result).isGreaterThanOrEqualTo(minBorder);
        assertThat(result).isLessThanOrEqualTo(maxBorder);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "shouldCheckGreaterOrEqualMethod.csv")
    void shouldCheckGreaterOrEqualMethod(int threshold, int minBorder, int maxBorder) {
        Integer result = new DefaultIntFaker().greaterOrEqual(threshold);
        assertThat(result).isGreaterThanOrEqualTo(minBorder);
        assertThat(result).isLessThanOrEqualTo(maxBorder);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "shouldCheckLessMethod.csv")
    void shouldCheckLessMethod(int threshold, int minBorder, int maxBorder) {
        Integer result = new DefaultIntFaker().less(threshold);
        assertThat(result).isGreaterThanOrEqualTo(minBorder);
        assertThat(result).isLessThanOrEqualTo(maxBorder);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "shouldCheckLessOrEqualMethod.csv")
    void shouldCheckLessOrEqualMethod(int threshold, int minBorder, int maxBorder) {
        Integer result = new DefaultIntFaker().lessOrEqual(threshold);
        assertThat(result).isGreaterThanOrEqualTo(minBorder);
        assertThat(result).isLessThanOrEqualTo(maxBorder);
    }
}