package ru.multa.entia.fakers.impl.strf;

import ru.multa.entia.fakers.api.strf.StringFakerSetting;
import ru.multa.entia.fakers.api.strf.StringFakerTemplate;

import java.util.Map;

record DefaultStringFakerTemplate(String template, Map<String, StringFakerSetting> settings)
        implements StringFakerTemplate {
}
