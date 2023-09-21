package ru.multa.entia.fakers.impl.strf;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultStringFakerSettingTest {
    @ParameterizedTest
    @CsvFileSource(resources = "shouldCheckCreation.csv")
    void shouldCheckCreation(int initMinLen,
                             int initMaxLen,
                             String initCC,
                             int expectedMinLen,
                             int expectedMaxLen,
                             String expectedCC) {
        expectedCC = expectedCC.replace("%20%", " ");
        int[] initCharCodes = calculateCharCodes(initCC);
        int[] expectedCharCodes = calculateCharCodes(expectedCC);

        DefaultStringFakerSetting setting = new DefaultStringFakerSetting(initMinLen, initMaxLen, initCharCodes);
        assertThat(setting.minLen()).isEqualTo(expectedMinLen);
        assertThat(setting.maxLen()).isEqualTo(expectedMaxLen);
        assertThat(setting.charCodes()).isEqualTo(expectedCharCodes);
    }

    private int[] calculateCharCodes(String line) {
        String[] split = line.split("-");
        int length = split.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = split[i].charAt(0);
        }

        return result;
    }
}