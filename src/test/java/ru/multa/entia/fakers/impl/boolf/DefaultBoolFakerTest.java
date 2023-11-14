package ru.multa.entia.fakers.impl.boolf;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultBoolFakerTest {
    private static final int TEST_AMOUNT =  100;

    @RepeatedTest(100)
    void shouldCheckRandomMethod() {
        int falseCounter = 0;
        int trueCounter = 0;
        for (int i = 0; i < TEST_AMOUNT; i++) {
            Boolean result = new DefaultBoolFaker().random();
            if (result != null) {
                if (result) {
                    trueCounter++;
                } else {
                    falseCounter++;
                }
            }
        }

        assertThat(falseCounter).isNotZero();
        assertThat(trueCounter).isNotZero();
        assertThat(trueCounter + falseCounter).isEqualTo(TEST_AMOUNT);
    }
}