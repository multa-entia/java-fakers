package ru.multa.entia.fakers.impl.strf;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.multa.entia.fakers.api.strf.StringFakerGenerator;
import ru.multa.entia.fakers.api.strf.StringFakerSetting;

import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultStringFakerTest {

    @ParameterizedTest
    @CsvFileSource(resources = "shouldCheckRandomGeneration.csv")
    void shouldCheckRandomGeneration(int initMin, int initMax, String expectedMinS, String expectedMaxS) {
        final int expectedMin = expectedMinS.equals("DefaultStringFaker.min")
                ? DefaultStringFaker.MIN_LEN
                : Integer.parseInt(expectedMinS);
        final int expectedMax = expectedMaxS.equals("DefaultStringFaker.max")
                ? DefaultStringFaker.MAX_LEN
                : Integer.parseInt(expectedMaxS);

        final String result = new DefaultStringFaker().random(initMin, initMax);

        final int length = result.length();
        assertThat(length).isGreaterThanOrEqualTo(expectedMin);
        assertThat(length).isLessThanOrEqualTo(expectedMax);
        for (int i = 0; i < result.length(); i++) {
            assertThat(result.charAt(i)).isGreaterThanOrEqualTo((char) DefaultStringFakerSetting.MIN_CHAR_CODE);
            assertThat(result.charAt(i)).isLessThanOrEqualTo((char) DefaultStringFakerSetting.MAX_CHAR_CODE);
        }
    }

    @Test
    void shouldCheckFromTemplateGeneration() {
        final String line = "some-line";
        final String first = "[a-z]{10:20}";
        final String second = "[01]{5:10}";
        final String template = String.format("_%s_%s_", first, second);
        final String expectedResult = String.format("_%s_%s_", line, line);

        TestGeneratorSupplier supplier = new TestGeneratorSupplier(line);
        DefaultStringFaker faker = new DefaultStringFaker(supplier);
        String result = faker.fromTemplate(template);

        assertThat(result).isEqualTo(expectedResult);
    }

    private record TestStringFakerGenerator(String line) implements StringFakerGenerator {
        @Override
        public String generate(StringFakerSetting setting) {
            return line;
        }
    }

    private record TestGeneratorSupplier(String line) implements Supplier<StringFakerGenerator> {
        @Override
        public StringFakerGenerator get() {
            return new TestStringFakerGenerator(line);
        }
    }
}