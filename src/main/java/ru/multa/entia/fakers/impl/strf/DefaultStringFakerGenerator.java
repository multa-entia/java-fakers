package ru.multa.entia.fakers.impl.strf;

import com.github.javafaker.Faker;
import ru.multa.entia.fakers.api.strf.StringFakerGenerator;
import ru.multa.entia.fakers.api.strf.StringFakerSetting;

import java.util.ArrayList;

public class DefaultStringFakerGenerator implements StringFakerGenerator {
    private final Faker faker = new Faker();

    @Override
    public String generate(final StringFakerSetting setting) {
        int[] charCodes = setting.charCodes();
        int size = charCodes.length / 2;
        ArrayList<Character> chars = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int start = charCodes[2 * i];
            int finish = charCodes[2 * i + 1];
            if (start >= finish){
                chars.add((char)start);
                chars.add((char)start);
            } else {
                for (int j = start; j < finish; j++){
                    chars.add((char)j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int charAmount = chars.size();
        int resultLen = faker.number().numberBetween(setting.minLen(), setting.maxLen() + 1);
        for (int i = 0; i < resultLen; i++) {
            int idx = faker.number().numberBetween(0, charAmount);
            sb.append(chars.get(idx));
        }

        return sb.toString();
    }
}
