package ru.multa.entia.fakers.impl.strf;

import com.github.javafaker.Faker;
import ru.multa.entia.fakers.api.strf.StringFaker;

public class DefaultStringFaker implements StringFaker {
    // TODO: 17.09.2023 ???
//    public static final int MIN_LEN = 1;
//    public static final int MAX_LEN = 10;
//    public static final int MIN_CHAR_CODE = 32;
//    public static final int MAX_CHAR_CODE = 126;

    private static Faker faker = new Faker();

    @Override
    public String random() {
        // TODO: 17.09.2023 impl
        /*
        		int length = core.number().numberBetween(MIN_LEN, MAX_LEN + 1);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			builder.append((char) core.number().numberBetween(MIN_CHAR_CODE, MAX_CHAR_CODE + 1));
		}

		return builder.toString();

         */
        return null;
    }

    @Override
    public String custom(String setting) {

        //< move to ???
//        String template = "\\[.+\\]\\{[0-9]+:[0-9]+\\}";
//        Pattern pattern = Pattern.compile(template);
//
//        Matcher matcher = pattern.matcher("[abc]{1:10}----");
//
//        System.out.println(matcher.groupCount());
//
//        int x = 0;
//        while (matcher.find()){
//            System.out.println(matcher.start());
//            System.out.println(matcher.end());
//            x++;
//        }
//        System.out.println(x);

        // TODO: 17.09.2023 impl
        return null;
    }

    @Override
    public String fromTemplate(String template) {
        // TODO: 17.09.2023 impl
        return null;
    }
}