package ru.multa.entia.fakers.impl.strf;

import ru.multa.entia.fakers.api.strf.StringFakerSetting;
import ru.multa.entia.fakers.api.strf.StringFakerSettingParser;
import ru.multa.entia.fakers.api.strf.StringFakerTemplate;
import ru.multa.entia.fakers.api.strf.StringFakerTemplateParser;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultStringFakerTemplateParser implements StringFakerTemplateParser {
    private static final String REGEX = "\\[[^{}]+\\]\\{[0-9]+:[0-9]+\\}";
    private static final String LABEL_TEMPLATE = "<@label_%s>";

    private final StringFakerSettingParser settingParser;

    public DefaultStringFakerTemplateParser() {
        this(new DefaultStringFakerSettingParser());
    }

    public DefaultStringFakerTemplateParser(final StringFakerSettingParser settingParser) {
        this.settingParser = settingParser;
    }

    @Override
    public StringFakerTemplate parse(final String template) {
        String line = template;

        HashMap<String, StringFakerSetting> settings = new HashMap<>();

        int counter = 0;
        final Pattern pattern = Pattern.compile(REGEX);
        while (true) {
            final Matcher matcher = pattern.matcher(line);
            if (matcher.find()){
                String substring = line.substring(matcher.start(), matcher.end());

                String label = String.format(LABEL_TEMPLATE, counter++);
                line = line.replaceFirst(REGEX, label);

                settings.put(label, settingParser.parse(substring));
            } else {
                break;
            }
        }

        return new DefaultStringFakerTemplate(line, settings);
    }
}
