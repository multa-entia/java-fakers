package ru.multa.entia.fakers.impl;

import ru.multa.entia.fakers.api.boolf.BoolFaker;
import ru.multa.entia.fakers.api.doublef.DoubleFaker;
import ru.multa.entia.fakers.api.floatf.FloatFaker;
import ru.multa.entia.fakers.api.intf.IntFaker;
import ru.multa.entia.fakers.api.longf.LongFaker;
import ru.multa.entia.fakers.api.strf.StringFaker;
import ru.multa.entia.fakers.api.strf.StringFakerGenerator;
import ru.multa.entia.fakers.api.uuidf.UuidFaker;
import ru.multa.entia.fakers.impl.boolf.DefaultBoolFaker;
import ru.multa.entia.fakers.impl.doublef.DefaultDoubleFaker;
import ru.multa.entia.fakers.impl.floatf.DefaultFloatFaker;
import ru.multa.entia.fakers.impl.intf.DefaultIntFaker;
import ru.multa.entia.fakers.impl.longf.DefaultLongFaker;
import ru.multa.entia.fakers.impl.strf.DefaultStringFaker;
import ru.multa.entia.fakers.impl.uuidf.DefaultUuidFaker;

import java.util.function.Supplier;

public class Faker {
    public static IntFaker int_(){
        return new DefaultIntFaker();
    }

    public static LongFaker long_(){
        return new DefaultLongFaker();
    }

    public static StringFaker str_(){
        return new DefaultStringFaker();
    }

    public static StringFaker str_(Supplier<StringFakerGenerator> generatorSupplier){
        return new DefaultStringFaker(generatorSupplier);
    }

    public static UuidFaker uuid_(){
        return new DefaultUuidFaker();
    }

    public static BoolFaker bool_() {
        return new DefaultBoolFaker();
    }

    public static FloatFaker float_() {
        return new DefaultFloatFaker();
    }

    public static DoubleFaker double_() {
        return new DefaultDoubleFaker();
    }
}
