package ru.multa.entia.fakers.impl.strf;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.multa.entia.fakers.api.strf.StringFakerSetting;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultStringFakerSettingParserTest {

    @ParameterizedTest
    @CsvFileSource(resources = "shouldCheckParsing.csv")
    void shouldCheckParsing(String template, String ranges, int expectedMinLen, int expectedMaxLen) {
        int[] expectedCharCodes = calculateCharCodes(ranges);

        StringFakerSetting setting = new DefaultStringFakerSettingParser().parse(template);
        assertThat(setting.minLen()).isEqualTo(expectedMinLen);
        assertThat(setting.maxLen()).isEqualTo(expectedMaxLen);
        assertThat(setting.charCodes()).isEqualTo(expectedCharCodes);
    }

    private int[] calculateCharCodes(String ranges) {
        ArrayList<Integer> list = new ArrayList<>();
        String[] splitRange = ranges.split("&");
        for (String item : splitRange) {
            int length = item.length();
            switch (length){
                case 1:
                    list.add((int)item.charAt(0));
                    list.add((int)item.charAt(0));
                    break;
                case 3:
                    list.add((int)item.charAt(0));
                    list.add((int)item.charAt(2));
                    break;
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}