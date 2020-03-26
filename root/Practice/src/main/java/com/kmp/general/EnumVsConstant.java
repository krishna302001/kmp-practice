package com.kmp.general;

import java.util.Arrays;

/**
 * 1. All enums implicitly extend java.lang.Enum class. Explicitly extending Enum will throw Compile time error.
 * 2. Enum provide values() method to get array of enums.
 * 3. Enums can implement any interface and override methods
 * 4. Enum in java implicitly implement both Serializable and Comparable interface
 * 5. Enums are Type Safe and enforce a limited set of values.
 * 6. Enums get store in string pool, thus enable to use == (double equals) operator.
 * 7. But I get the codes from an external source. then need to override default constructor.
 * 8. enum classes cannot have finalize methods.
 */
public class EnumVsConstant {
    private static final String male = "MALE";
    private static final String male2 = "MALE";
    private static final String male3 = new String("MALE");
    public static final String ONE = "ONE";


    public static void main(String[] args) {


        GenderEnum gender = GenderEnum.fromCode("M");
        Arrays.stream(GenderEnum.values()).forEach(e -> System.out.println(e));
        if (male == GenderEnum.fromCode("M").toString()) {
            System.out.println("It's M");
            System.out.println(GenderEnum.MALE);
        }

        if (male == male2) {
            System.out.println("It's M2");
        }
        if (male == male3) {
            System.out.println("It's M3");
        }else{
            System.out.println("It's not same");
        }

        System.out.println(Foo.ONE);
        System.out.println(Foo.valueOf("ONE"));
        System.out.println(Foo.fromValue("2"));
        if (ONE == Foo2.ONE.toString())
            System.out.println("SAME");
    }


}

enum GenderEnum {
    MALE("M"), FEMALE("F");

    private final String code;

    private GenderEnum(String code) {
        this.code = code;
    }

    private String code() {
        return this.code;
    }

    public static GenderEnum fromCode(String code) {
        if (code != null) {
            for (GenderEnum g : GenderEnum.values()) {
                if (code.equalsIgnoreCase(g.code())) {
                    return g;
                }
            }
        }
        return null;
    }


}

enum Foo2 {
    ONE, TWO;
}

enum Foo {
    ONE("1"), TWO("2");
    final private String code;

    Foo(String code) {
        this.code = code;
    }

    public static Foo fromValue(String code) {
        if (null != code) {
            for (Foo foo : Foo.values()
            ) {
                if (code.equalsIgnoreCase(foo.code)) {
                    return foo;
                }
            }
        }
        return null;
    }
}

class GenderConstants {
    public static final String MALE = "M";
    public static final String FEMALE = "F";

    public String[] getValues() {
        return new String[]{MALE, FEMALE};
    }
}