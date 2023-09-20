package ru.multa.entia.fakers.impl.strf;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import ru.multa.entia.fakers.api.strf.StringFakerSetting;
import ru.multa.entia.fakers.api.strf.StringFakerSettingParser;
import ru.multa.entia.fakers.api.strf.StringFakerTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultStringFakerTemplateParserTest {

    @Test
    void shouldCheckParsing() {
        String template = "prefix [012]{1:3} middle [a-z]{3:7} suffix";
        String expectedTemplate = "prefix <@label_0> middle <@label_1> suffix";

        TestStringFakerSettingParser settingParser = new TestStringFakerSettingParser();
        Map<String, StringFakerSetting> expectedSettings = new HashMap<>(){{
            put("<@label_0>", settingParser.parse("[012]{1:3}"));
            put("<@label_1>", settingParser.parse("[a-z]{3:7}"));
        }};

        DefaultStringFakerTemplateParser parser = new DefaultStringFakerTemplateParser(settingParser);
        StringFakerTemplate result = parser.parse(template);

        assertThat(result.template()).isEqualTo(expectedTemplate);
        assertThat(result.settings()).isEqualTo(expectedSettings);
    }

    private static class TestStringFakerSettingParser implements StringFakerSettingParser {
        @Override
        public StringFakerSetting parse(String line) {
            int length = line.length();
            int[] charCodes = new int[length];
            for (int i = 0; i < length; i++) {
                charCodes[i] = line.charAt(i);
            }
            return new TestStringFakerSetting(0, 0, charCodes);
        }
    }

    @RequiredArgsConstructor
    @EqualsAndHashCode
    private static class TestStringFakerSetting implements StringFakerSetting {
        private final int minLen ;
        private final int maxLen;
        private final int[] charCodes;

        @Override
        public int minLen() { return minLen; }

        @Override
        public int maxLen() { return maxLen; }

        @Override
        public int[] charCodes() { return charCodes; }
    }
}