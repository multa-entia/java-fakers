package ru.multa.entia.fakers.api;

public interface ComparisonFaker<T> {
    T between(T min, T max);
    T greater(T threshold);
    T greaterOrEqual(T threshold);
    T less(T threshold);
    T lessOrEqual(T threshold);
}
