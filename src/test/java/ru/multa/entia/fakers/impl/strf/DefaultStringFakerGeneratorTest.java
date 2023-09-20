package ru.multa.entia.fakers.impl.strf;

import org.junit.jupiter.api.Test;
import ru.multa.entia.fakers.api.strf.StringFakerSetting;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultStringFakerGeneratorTest {
    @Test
    void shouldCheckGeneration() {
        String templateItemA = "a";
        String templateItemB = "b";
        String templateItemC = "c";
        String templateItemRange = "xz";

        TestStringFakerSetting setting = new TestStringFakerSetting(
                List.of(templateItemA, templateItemB, templateItemC, templateItemRange)
        );

        String result = new DefaultStringFakerGenerator().generate(setting);

        int length = result.length();
        assertThat(length).isGreaterThanOrEqualTo(setting.minLen());
        assertThat(length).isLessThanOrEqualTo(setting.maxLen());
        for (int i = 0; i < length; i++) {
            char ch = result.charAt(i);
            boolean success = ch == templateItemA.charAt(0) ||
                    ch == templateItemB.charAt(0) ||
                    ch == templateItemC.charAt(0) ||
                    (templateItemRange.charAt(0) <= ch && ch <= templateItemRange.charAt(1));
            assertThat(success).isTrue();
        }
    }

    private record TestStringFakerSetting(List<String> charCodesTemplate) implements StringFakerSetting {
        public int minLen() {
            return 1;
        }

        public int maxLen() {
            return 10;
        }

        public int[] charCodes() {
            ArrayList<Integer> list = new ArrayList<>();
            for (String line : charCodesTemplate) {
                switch (line.length()) {
                    case 1:
                        list.add((int) line.charAt(0));
                        list.add((int) line.charAt(0));
                        break;
                    case 2:
                        list.add((int) line.charAt(0));
                        list.add((int) line.charAt(1));
                        break;
                }
            }

            int[] charCodes = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                charCodes[i] = list.get(i);
            }

            return charCodes;
        }
    }
}