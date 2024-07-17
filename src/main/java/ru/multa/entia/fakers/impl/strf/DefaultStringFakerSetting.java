package ru.multa.entia.fakers.impl.strf;

import ru.multa.entia.fakers.api.strf.StringFakerSetting;

import java.util.Arrays;

record DefaultStringFakerSetting(int minLen, int maxLen, int[] charCodes) implements StringFakerSetting {
    public static final int MIN_CHAR_CODE = 32;
    public static final int MAX_CHAR_CODE = 122;
    private static final int MIN_LEN = 1;

    public DefaultStringFakerSetting {
        minLen = Math.max(minLen, MIN_LEN);
        maxLen = Math.max(minLen, maxLen);

        if (charCodes == null || charCodes.length < 2) {
            charCodes = new int[]{MIN_CHAR_CODE, MAX_CHAR_CODE};
        } else if (charCodes.length % 2 == 1) {
            charCodes = Arrays.copyOf(charCodes, charCodes.length / 2 * 2);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DefaultStringFakerSetting setting = (DefaultStringFakerSetting) o;

        if (minLen != setting.minLen) return false;
        if (maxLen != setting.maxLen) return false;
        return Arrays.equals(charCodes, setting.charCodes);
    }

    @Override
    public int hashCode() {
        int result = minLen;
        result = 31 * result + maxLen;
        result = 31 * result + Arrays.hashCode(charCodes);
        return result;
    }
}
