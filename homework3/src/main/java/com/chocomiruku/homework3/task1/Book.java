package com.chocomiruku.homework3.task1;

import static com.chocomiruku.homework3.Util.formatPrice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Book implements Publication {

    private final double price;
    private final int wordCount;

    public Book(double price, int wordCount) {
        this.price = price;
        this.wordCount = wordCount;
    }

    @Override
    public String getType() {
        if (wordCount <= 0) throw new IllegalArgumentException("WordCount should be positive");

        if (wordCount > 7500) {
            return "Novel";
        } else if (wordCount > 1000) {
            return "Short Story";
        }
        return "Flash Fiction";
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Book)) {
            return false;
        }

        Book other = (Book) obj;
        return other.price == this.price && other.wordCount == this.wordCount;
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