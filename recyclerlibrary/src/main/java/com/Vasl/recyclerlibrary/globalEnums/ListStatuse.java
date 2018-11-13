package com.Vasl.recyclerlibrary.globalEnums;

public enum ListStatuse {
    UNDEFINE("undefine"),
    FAILURE("failure"),
    LOADING("layout_loading"),
    SUCCESS("success"),
    EMPTY("empty");

    private String value;

    ListStatuse(String value) {
        this.value = value;
    }

    public String getCode() {
        return value;
    }

    public static ListStatuse Parse(String value) {
        if (value == null) {
            return UNDEFINE;
        }
        ListStatuse[] arr$ = values();
        for (ListStatuse val : arr$) {
            if (val.value.equals(value)) {
                return val;
            }
        }
        return UNDEFINE;
    }


}
