package ru.multa.entia.fakers.impl.strf;

import ru.multa.entia.fakers.api.strf.StringFakerSetting;

import java.util.Arrays;

record DefaultStringFakerSetting(int minLen, int maxLen, int[] charCodes) implements StringFakerSetting {
    private static final int MIN_LEN = 1;
    private static final int MIN_CHAR_CODE = 32;
    private static final int MAX_CHAR_CODE = 122;

    public DefaultStringFakerSetting {
        minLen = Math.max(minLen, MIN_LEN);
        maxLen = Math.max(minLen, maxLen);

        if (charCodes == null || charCodes.length < 2) {
            charCodes = new int[]{MIN_CHAR_CODE, MAX_CHAR_CODE};
        } else if (charCodes.length % 2 == 1) {
            charCodes = Arrays.copyOf(charCodes, charCodes.length / 2 * 2);
        }
    }
}
