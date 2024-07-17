package ru.multa.entia.fakers.impl.floatf;

import com.github.javafaker.Faker;
import ru.multa.entia.fakers.api.floatf.FloatFaker;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DefaultFloatFaker implements FloatFaker {
    private final Faker faker = new Faker();

    @Override
    public Float random(final Object... args) {
        float range = (float) Long.MAX_VALUE - (float) Long.MIN_VALUE;
        float chunkCount = (float) Math.sqrt(Math.abs(range));
        float chunkSize = chunkCount;
        long randomChunk = faker.random().nextLong((long) chunkCount);
        float chunkStart = (float) Long.MIN_VALUE + (float) randomChunk * chunkSize;
        float adj = chunkStart * (float) faker.random().nextInt(Integer.MAX_VALUE);

//        RoundingMode
        return new BigDecimal(chunkStart + adj)
                .setScale(faker.random().nextInt(0, 10), RoundingMode.UNNECESSARY)
                .floatValue();

//                double adj = chunkSize * this.faker.random().nextDouble();
//                return new BigDecimal(chunkStart + adj);

//        faker.number().randomDouble()
//        return this.decimalBetween(min, max).setScale(maxNumberOfDecimals, 5).doubleValue();

                // TODO: !!!
//        private BigDecimal decimalBetween(long min, long max) {
//            if (min == max) {
//                return new BigDecimal(min);
//            } else {
//                long trueMin = Math.min(min, max);
//                long trueMax = Math.max(min, max);
//                double range = (double)trueMax - (double)trueMin;
//                double chunkCount = Math.sqrt(Math.abs(range));
//                double chunkSize = chunkCount;
//                long randomChunk = this.faker.random().nextLong((long)chunkCount);
//                double chunkStart = (double)trueMin + (double)randomChunk * chunkSize;
//                double adj = chunkSize * this.faker.random().nextDouble();
//                return new BigDecimal(chunkStart + adj);
//            }
//        }

//        throw new RuntimeException("random");
        // TODO: !!!
//        return null;
    }

    @Override
    public Float between(final Float min, final Float max) {
        throw new RuntimeException("between");
        // TODO: !!!
//        return 0f;
    }

    @Override
    public Float greater(final Float threshold) {
        throw new RuntimeException("greater");
        // TODO: !!!
//        return 0f;
    }

    @Override
    public Float greaterOrEqual(final Float threshold) {
        throw new RuntimeException("greaterOrEqual");
        // TODO: !!!
//        return 0f;
    }

    @Override
    public Float less(final Float threshold) {
        throw new RuntimeException("less");
        // TODO: !!!
//        return 0f;
    }

    @Override
    public Float lessOrEqual(final Float threshold) {
        throw new RuntimeException("lessOrEqual");
        // TODO: !!!
//        return 0f;
    }
}
