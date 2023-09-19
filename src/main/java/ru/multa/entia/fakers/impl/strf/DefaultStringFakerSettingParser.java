package ru.multa.entia.fakers.impl.strf;

import ru.multa.entia.fakers.api.strf.StringFakerSetting;
import ru.multa.entia.fakers.api.strf.StringFakerSettingParser;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                maxLen = value > 0 ? value : MAX_LEN;
            } catch (Exception ignored) {}

            if (minLen > maxLen){
                maxLen = minLen;
            }
        }

        return new int[]{minLen, maxLen};
    }

    private int[] calculateCharCodes(final String charSubstring) {
        ArrayList<Character> list = new ArrayList<>();

        Pattern pattern = Pattern.compile(".-.");
        Matcher matcher = pattern.matcher(charSubstring);
        int start = 0;
        while (matcher.find()){
            int matcherStart = matcher.start();
            int matcherEnd = matcher.end() - 1;
            for (int i = start;  i < matcherStart; i++){
                list.add(charSubstring.charAt(i));
                list.add(charSubstring.charAt(i));
            }
            list.add(charSubstring.charAt(matcherStart));
            list.add(charSubstring.charAt(matcherEnd));

            start = matcherEnd + 1;
        }

        for (int i = start; i < charSubstring.length(); i++){
            list.add(charSubstring.charAt(i));
            list.add(charSubstring.charAt(i));
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = (int) list.get(i);
        }

        return result.length > 0 ? result : new int[]{MIN_CHAR_CODE, MAX_CHAR_CODE};
    }
}
