package ru.multa.entia.fakers.impl.strf;

import org.junit.jupiter.api.Test;
import ru.multa.entia.fakers.api.strf.StringFakerSetting;
import ru.multa.entia.fakers.api.strf.StringFakerSettingParser;

import static org.junit.jupiter.api.Assertions.*;

class DefaultStringFakerTemplateParserTest {

    @Test
    void shouldCheckParsing() {
        DefaultStringFakerTemplateParser parser = new DefaultStringFakerTemplateParser(
                new TestStringFakerSettingParser()
        );


    }

    private static class TestStringFakerSettingParser implements StringFakerSettingParser {
        @Override
        public StringFakerSetting parse(String line) {
            int length = line.length();
            int[] charCodes = new int[length];
            for (int i = 0; i < length; i++) {
                charCodes[i] = line.charAt(i);
            }
            return new DefaultStringFakerSetting(0, 0, charCodes);
        }
    }
}