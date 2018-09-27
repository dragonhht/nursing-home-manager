package com.github.dragonhht.manager.params;

/**
 * Description.
 * User: huang
 * Date: 18-9-21
 */
public enum Code {
    NOT_LOGIN(801),
    SUCCESS(200),
    FAILED(701),
    UNAUTHORIZE(401);

    private int value;

    Code(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static int getCode(Code code) {
        return code.getValue();
    }

}
