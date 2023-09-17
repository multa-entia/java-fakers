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
        // TODO: 17.09.2023 impl
        return null;
    }

    @Override
    public String fromTemplate(String template) {
        // TODO: 17.09.2023 impl
        return null;
    }
}
