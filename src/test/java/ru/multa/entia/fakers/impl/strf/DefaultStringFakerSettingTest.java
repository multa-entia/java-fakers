package ru.multa.entia.fakers.impl.strf;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultStringFakerSettingTest {

    @Test
    void shouldCheckMinLenGetting() {
        int expected = 123;
        DefaultStringFakerSetting setting = new DefaultStringFakerSetting(expected, 0, null);
        assertThat(setting.minLen()).isEqualTo(expected);
    }

    @Test
    void shouldCheckMaxLenGetting() {
        int expected = 456;
        DefaultStringFakerSetting setting = new DefaultStringFakerSetting(0, expected, null);
        assertThat(setting.maxLen()).isEqualTo(expected);
    }

    @Test
    void shouldCheckCharCodes() {
        int[] expected = {1, 2, 3, 4};
        DefaultStringFakerSetting setting = new DefaultStringFakerSetting(0, 0, expected);
        assertThat(setting.charCodes()).isEqualTo(expected);
    }
}