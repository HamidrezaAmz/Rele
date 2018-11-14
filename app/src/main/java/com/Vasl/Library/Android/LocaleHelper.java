package com.Vasl.Library.Android;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;

import java.util.Locale;

/**
 * Created by Reza Amozadeh on 4/9/2017.
 */

public class LocaleHelper {

    private static String LocalizationEN = "en";

    private static String LocalizationFA = "fa";

    public static void onAttach(Context context) {
        LocaleHelper.setLocal(context);
    }

    public static void onAttach(Context context, String defaultLanguage) {
        LocaleHelper.setLocal(context, defaultLanguage);
    }

    @SuppressWarnings("deprecation")
    public static void setSystemLocaleLegacy(Configuration config, Locale locale) {
        config.locale = locale;
    }

    @TargetApi(Build.VERSION_CODES.N)
    public static void setSystemLocale(Configuration config, Locale locale) {
        config.setLocale(locale);
    }

    public static void setLocal(Context context) {
        setLocal(context, getLanguageSetting(context));
    }

    private static String getLanguageSetting(Context context) {
        return LocalizationFA;
    }

    public static void setLocal(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            setSystemLocale(config, locale);
        } else {
            setSystemLocaleLegacy(config, locale);
        }
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            context.getApplicationContext().getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
        } else {
            context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
        }
    }

    public static String getLocal() {
        Locale localHelper = Locale.getDefault();
        return localHelper.getLanguage();
    }

    public static Boolean isRTL() {
        return getLocal().equals(LocalizationFA);
    }

}
