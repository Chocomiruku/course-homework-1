package com.chocomiruku.homework3.task1;

import static com.chocomiruku.homework3.Util.formatPrice;

import androidx.annotation.NonNull;

public class Magazine implements Publication {
    private final double price;
    private final int wordCount;

    public Magazine(double price, int wordCount) {
        this.price = price;
        this.wordCount = wordCount;
    }

    @Override
    public String getType() {
        if (wordCount <= 0) throw new IllegalArgumentException("WordCount should be positive");

        return "Magazine";
    }

    @NonNull
    @Override
    public String toString() {
        return "Type: " + getType() + "\n" + "Price: " + formatPrice(price) + ", Words: " + wordCount;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}