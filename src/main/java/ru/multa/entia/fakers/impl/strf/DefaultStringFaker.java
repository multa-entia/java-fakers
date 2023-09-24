package ru.multa.entia.fakers.impl.strf;

import ru.multa.entia.fakers.api.strf.StringFaker;
import ru.multa.entia.fakers.api.strf.StringFakerGenerator;
import ru.multa.entia.fakers.api.strf.StringFakerSetting;
import ru.multa.entia.fakers.api.strf.StringFakerTemplate;

import java.util.Map;
import java.util.function.Supplier;

public class DefaultStringFaker implements StringFaker {
    public static final int MIN_LEN = 5;
    public static final int MAX_LEN = 10;

    private final Supplier<StringFakerGenerator> generatorSupplier;

    public DefaultStringFaker(Supplier<StringFakerGenerator> generatorSupplier) {
        this.generatorSupplier = generatorSupplier;
    }

    public DefaultStringFaker() {
        this.generatorSupplier = DefaultStringFakerGenerator::new;
    }

    @Override
    public String random(Object... args) {
        int minLen = args.length > 0 && args[0].getClass().equals(Integer.class) && ((int)args[0]) > 0
                ? (int) args[0]
                : MIN_LEN;
        int maxLen = args.length > 1 && args[1].getClass().equals(Integer.class) && ((int)args[1]) > 0
                ? (int) args[1]
                : MAX_LEN;

        DefaultStringFakerSetting setting = new DefaultStringFakerSetting(minLen, maxLen, null);
        return generatorSupplier.get().generate(setting);
    }

    @Override
    public String fromTemplate(String template) {
        StringFakerGenerator generator = generatorSupplier.get();
        StringFakerTemplate parsedTemplate = new DefaultStringFakerTemplateParser().parse(template);
        String result = parsedTemplate.template();
        for (Map.Entry<String, StringFakerSetting> entry : parsedTemplate.settings().entrySet()) {
            String oldSub = entry.getKey();
            String newSub = generator.generate(entry.getValue());
            result = result.replace(oldSub, newSub);
        }

        return result;
    }
}
