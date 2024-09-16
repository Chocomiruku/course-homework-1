package com.chocomiruku.homework3;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Locale;

public final class Util {
    public static String formatPrice(double price) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        formatter.setCurrency(Currency.getInstance("EUR"));
        return formatter.format(price);
    }

    public static String convertLongToTimeString(Long systemTime) {
        return new SimpleDateFormat("HH:mm:ss", Locale.getDefault())
                .format(systemTime);
    }
}
