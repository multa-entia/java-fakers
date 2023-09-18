package ru.multa.entia.fakers.impl.strf;

import ru.multa.entia.fakers.api.strf.StringFakerSetting;
import ru.multa.entia.fakers.api.strf.StringFakerSettingParser;

import java.util.Arrays;

public class DefaultStringFakerSettingParser implements StringFakerSettingParser {
    public static final int MIN_LEN = 1;
    public static final int MAX_LEN = 10;
    public static final int MIN_CHAR_CODE = 32;
    public static final int MAX_CHAR_CODE = 126;

    @Override
    public StringFakerSetting parse(final String line) {
        String[] split = line.substring(1, line.length() - 1).split("]\\{");
        String charSubstring = split[0];
        String lenSubstring = split[1];

        int[] lens = calculateLens(lenSubstring);
        return new DefaultStringFakerSetting(lens[0], lens[1], calculateCharCodes(charSubstring));
    }

    private int[] calculateLens(final String lenSubstring) {
        int minLen = MIN_LEN;
        int maxLen = MAX_LEN;
        String[] split = lenSubstring.split(":");
        if (split.length == 2){
            try {
                int value = Integer.parseInt(split[0]);
                minLen = value > 0 ? value : MIN_LEN;
            } catch (Exception ignored){}

            try {
                int value = Integer.parseInt(split[1]);
                maxLen = value > 0 ? maxLen : MAX_LEN;
            } catch (Exception ignored) {}

            if (minLen > maxLen){
                maxLen = minLen;
            }
        }

        return new int[]{minLen, maxLen};
    }

    private int[] calculateCharCodes(final String charSubstring) {
        String line = charSubstring;

        // TODO: 18.09.2023 !!!
        System.out.println(line);
        boolean dashInBegin = line.charAt(0) == '-';
        if (dashInBegin){
            line = line.substring(1);
        }
        boolean dashInEnd = line.charAt(line.length() - 1) == '-';
        if (dashInEnd){
            line = line.substring(0, line.length()-1);
        }
        // TODO: 18.09.2023 !!!
        System.out.println(line);

        String[] split = line.split("-");
        System.out.println(Arrays.toString(split));


//        String[] split = charSubstring.split("-");
//        System.out.println(Arrays.toString(split));
        return new int[0];
    }
}
