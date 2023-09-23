package ru.multa.entia.fakers.impl.strf;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.multa.entia.fakers.api.strf.StringFakerSetting;

import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultStringFakerSettingParserTest {

    @ParameterizedTest
    @CsvFileSource(resources = "shouldCheckLengthsCalculator.csv")
    void shouldCheckLengthsCalculator(String line, int expectedMin, int expectedMax) {
        int[] result = new DefaultStringFakerSettingParser.LengthsCalculator().apply(line);
        assertThat(result).hasSize(2);
        assertThat(result[0]).isEqualTo(expectedMin);
        assertThat(result[1]).isEqualTo(expectedMax);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "shouldCheckCharCodesCalculator.csv")
    void shouldCheckCharCodesCalculator(String line, String expectedLine) {
        int[] expected = calculateExpectedCharCodes(expectedLine);
        int[] result = new DefaultStringFakerSettingParser.CharCodesCalculator().apply(line);

        assertThat(result).isEqualTo(expected);
    }

    private int[] calculateExpectedCharCodes(String line) {
        String[] split = line.split("-");
        int[] charCodes = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            try{
                charCodes[i] = Integer.parseInt(split[i]);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }

        return charCodes;
    }

    @Test
    void shouldCheckParsing_ifLineNull() {
        StringFakerSetting result = new DefaultStringFakerSettingParser().parse(null);
        assertThat(result).isEqualTo(new DefaultStringFakerSetting(0,0, null));
    }

    @Test
    void shouldCheckParsing_ifLineIsShort() {
        StringFakerSetting result = new DefaultStringFakerSettingParser().parse("");
        assertThat(result).isEqualTo(new DefaultStringFakerSetting(0,0, null));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "shouldCheckParsing_ifLineHasBadFormat.csv")
    void shouldCheckParsing_ifLineHasBadFormat(String line) {
        StringFakerSetting result = new DefaultStringFakerSettingParser().parse(line);
        assertThat(result).isEqualTo(new DefaultStringFakerSetting(0,0, null));
    }

    @Test
    void shouldCheckParsing() {
        final int expectedMinLen = 1;
        final int expectedMaxLen = 10;
        final char ch00 = '0';
        final char ch10 = '2';
        final char ch11 = 'd';
        final String charCodesPart = String.format("%s%s-%s", ch00, ch10, ch11);
        final String lensPart = String.format("%s:%s", expectedMinLen, expectedMaxLen);
        final String template = String.format("[%s]{%s}", charCodesPart, lensPart);
        final int[] expectedLens = {expectedMinLen, expectedMaxLen};
        final int[] expectedCharCodes = {ch00, ch00, ch10, ch11};

        Function<List<int[]>, StringFakerSetting> stringFakerSettingCreator = new Function<List<int[]>, StringFakerSetting>() {
            @Override
            public StringFakerSetting apply(List<int[]> list) {
                return new DefaultStringFakerSetting(list.get(0)[0], list.get(0)[1], list.get(1));
            }
        };

        TestCalculator lengthsCalculator = new TestCalculator(expectedLens);
        TestCalculator charCodesCalculator = new TestCalculator(expectedCharCodes);
        StringFakerSetting result = new DefaultStringFakerSettingParser(
                stringFakerSettingCreator,
                lengthsCalculator,
                charCodesCalculator
        ).parse(template);

        assertThat(lengthsCalculator.getLine()).isEqualTo(lensPart);
        assertThat(charCodesCalculator.getLine()).isEqualTo(charCodesPart);
        assertThat(result).isEqualTo(new DefaultStringFakerSetting(expectedMinLen, expectedMaxLen, expectedCharCodes));
    }

    @RequiredArgsConstructor
    private static class TestCalculator implements Function<String, int[]> {
        private final int[] ints;

        @Getter
        private String line;

        @Override
        public int[] apply(String line) {
            this.line = line;
            return ints;
        }
    }
}