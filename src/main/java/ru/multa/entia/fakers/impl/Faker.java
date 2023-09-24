package ru.multa.entia.fakers.impl;

import ru.multa.entia.fakers.api.intf.IntFaker;
import ru.multa.entia.fakers.api.longf.LongFaker;
import ru.multa.entia.fakers.api.strf.StringFaker;
import ru.multa.entia.fakers.api.strf.StringFakerGenerator;
import ru.multa.entia.fakers.api.uuidf.UuidFaker;
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
}
