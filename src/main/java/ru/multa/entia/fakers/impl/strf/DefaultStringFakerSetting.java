package ru.multa.entia.fakers.impl.strf;

import ru.multa.entia.fakers.api.strf.StringFakerSetting;

record DefaultStringFakerSetting(int minLen, int maxLen, int[] charCodes) implements StringFakerSetting {}
