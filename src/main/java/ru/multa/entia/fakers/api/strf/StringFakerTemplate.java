package ru.multa.entia.fakers.api.strf;

import java.util.Map;

public interface StringFakerTemplate {
    String template();
    Map<String, StringFakerSetting> settings();
}
