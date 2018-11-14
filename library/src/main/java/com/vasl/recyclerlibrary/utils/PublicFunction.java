package com.vasl.recyclerlibrary.utils;

public class PublicFunction {

    public static Boolean StringIsEmptyOrNull(String string) {
        try {
            if (string == null || string.equals(null) || string.length() == 0 || string.isEmpty() || string.equals("null") || string.equals(""))
                return true;
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

}
