package ru.multa.entia.fakers.api.strf;

import ru.multa.entia.fakers.api.GenFaker;

public interface StringFaker extends GenFaker<String> {
    String custom(String setting);
    String fromTemplate(String template);
}
