package ru.multa.entia.fakers.impl.strf;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.multa.entia.fakers.api.strf.StringFakerSetting;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DefaultStringFakerTemplateTest {

    @Test
    void shouldCheckTemplateGetting_ifNull() {
        DefaultStringFakerTemplate result = new DefaultStringFakerTemplate(null, null);
        assertThat(result.template()).isNull();
    }

    @Test
    void shouldCheckTemplateGetting() {
        String expected = "expected";
        DefaultStringFakerTemplate result = new DefaultStringFakerTemplate(expected, null);
        assertThat(result.template()).isEqualTo(expected);
    }

    @Test
    void shouldCheckSettingsGetting_ifNull() {
        DefaultStringFakerTemplate result = new DefaultStringFakerTemplate(null, null);
        assertThat(result.settings()).isNull();;
    }

    @Test
    void shouldCheckSettingsGetting() {
        HashMap<String, StringFakerSetting> expected = new HashMap<>() {{
            put("key", new TestStringFakerSetting());
        }};
        DefaultStringFakerTemplate result = new DefaultStringFakerTemplate(null, expected);
        assertThat(result.settings()).isEqualTo(expected);
    }

    private static class TestStringFakerSetting implements StringFakerSetting {
        @Override
        public int minLen() { return 0; }
        @Override
        public int maxLen() { return 0; }
        @Override
        public int[] charCodes() { return new int[0]; }
    }
}