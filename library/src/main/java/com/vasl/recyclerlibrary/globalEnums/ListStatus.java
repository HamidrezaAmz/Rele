package com.vasl.recyclerlibrary.globalEnums;

public enum ListStatus {

    UNDEFINE("undefine"),
    FAILURE("failure"),
    LOADING("layout_loading"),
    SUCCESS("success"),
    LOADING_BOTTOM("loading_bottom"),
    EMPTY("empty");

    private String value;

    ListStatus(String value) {
        this.value = value;
    }

    public String getCode() {
        return value;
    }

    public static ListStatus Parse(String value) {
        if (value == null) {
            return UNDEFINE;
        }
        ListStatus[] arr$ = values();
        for (ListStatus val : arr$) {
            if (val.value.equals(value)) {
                return val;
            }
        }
        return UNDEFINE;
    }
}
