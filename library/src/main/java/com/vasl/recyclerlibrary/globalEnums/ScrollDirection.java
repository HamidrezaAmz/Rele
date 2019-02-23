package com.vasl.recyclerlibrary.globalEnums;

public enum ScrollDirection {

    UNDEFINE("undefine"),
    UP("UP"),
    DOWN("DOWN");

    private String value;

    ScrollDirection(String value) {
        this.value = value;
    }

    public String getCode() {
        return value;
    }

    public static ScrollDirection Parse(String value) {
        if (value == null) {
            return UNDEFINE;
        }
        ScrollDirection[] arr$ = values();
        for (ScrollDirection val : arr$) {
            if (val.value.equals(value)) {
                return val;
            }
        }
        return UNDEFINE;
    }


}
