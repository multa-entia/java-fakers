package ru.multa.entia.fakers.impl.strf;

import ru.multa.entia.fakers.api.strf.StringFakerSettingParser;
import ru.multa.entia.fakers.api.strf.StringFakerTemplate;
import ru.multa.entia.fakers.api.strf.StringFakerTemplateParser;

public class DefaultStringFakerTemplateParser implements StringFakerTemplateParser {
    private static final String LABEL_TEMPLATE = "<@label_%s>";

    private final StringFakerSettingParser settingParser;

    public DefaultStringFakerTemplateParser() {
        this(new DefaultStringFakerSettingParser());
    }

    public DefaultStringFakerTemplateParser(StringFakerSettingParser settingParser) {
        this.settingParser = settingParser;
    }

    @Override
    public StringFakerTemplate parse(String template) {
        // TODO: 19.09.2023 !!!
//        text [wwf]{wefwef} qenkjefb []{} adqdqwd
//        String template = "\\[.+\\]\\{[0-9]+:[0-9]+\\}";
        return null;
    }
}
