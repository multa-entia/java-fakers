package ru.multa.entia.fakers.impl.strf;

import ru.multa.entia.fakers.api.strf.StringFakerSetting;
import ru.multa.entia.fakers.api.strf.StringFakerSettingParser;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultStringFakerSettingParser implements StringFakerSettingParser {
    // TODO: 21.09.2023 !!!
//    public static final int MIN_LEN = 1;
//    public static final int MAX_LEN = 10;
//    public static final int MIN_CHAR_CODE = 32;
//    public static final int MAX_CHAR_CODE = 126;

    private final Function<List<int[]>, StringFakerSetting> stringFakerSettingCreator;
    private final Function<String, int[]> lengthsCalculator;
    private final Function<String, int[]> charCodesCalculator;

    public DefaultStringFakerSettingParser() {
        this(list -> { return new DefaultStringFakerSetting(list.get(0)[0], list.get(0)[1], list.get(1)); });
    }

    public DefaultStringFakerSettingParser(Function<List<int[]>, StringFakerSetting> stringFakerSettingCreator) {
        this(stringFakerSettingCreator, new LengthsCalculator(), new CharCodesCalculator());
    }

    public DefaultStringFakerSettingParser(Function<List<int[]>, StringFakerSetting> stringFakerSettingCreator,
                                           Function<String, int[]> lengthsCalculator,
                                           Function<String, int[]> charCodesCalculator) {
        this.stringFakerSettingCreator = stringFakerSettingCreator;
        this.lengthsCalculator = lengthsCalculator;
        this.charCodesCalculator = charCodesCalculator;
    }

    @Override
    public StringFakerSetting parse(final String line) {
        return null;

        // TODO: 21.09.2023 !!!
//        String[] split = line.substring(1, line.length() - 1).split("]\\{");
//        String charSubstring = split[0];
//        String lenSubstring = split[1];
//
//        int[] lens = calculateLens(lenSubstring);
//        return new DefaultStringFakerSetting(lens[0], lens[1], calculateCharCodes(charSubstring));
    }

    public static class LengthsCalculator implements Function<String, int[]>{
        @Override
        public int[] apply(final String line) {
            int[] result = new int[]{0, 0};

            String[] split = line.split(":");
            if (split.length == 2){
                for (int i = 0; i < 2; i++) {
                    try {
                        result[i] = Integer.parseInt(split[i]);
                    } catch (Exception ignored) {}
                }
            }

            return result;
        }
    }

    public static class CharCodesCalculator implements Function<String, int[]> {
        @Override
        public int[] apply(final String line) {
            ArrayList<Character> list = new ArrayList<>();

            Pattern pattern = Pattern.compile(".-.");
            Matcher matcher = pattern.matcher(line);
            int start = 0;
            while (matcher.find()){
                int matcherStart = matcher.start();
                int matcherEnd = matcher.end() - 1;
                for (int i = start;  i < matcherStart; i++){
                    list.add(line.charAt(i));
                    list.add(line.charAt(i));
                }
                list.add(line.charAt(matcherStart));
                list.add(line.charAt(matcherEnd));

                start = matcherEnd + 1;
            }

            for (int i = start; i < line.length(); i++){
                list.add(line.charAt(i));
                list.add(line.charAt(i));
            }

            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = (int) list.get(i);
            }

            return result;
        }
    }
}
