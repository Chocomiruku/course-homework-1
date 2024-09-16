package com.chocomiruku.homework3.task1;

import static com.chocomiruku.homework3.Util.formatPrice;

import androidx.annotation.NonNull;

import com.chocomiruku.homework3.task2.Operation;

public class FirstTask {
    public void buy(@NonNull Publication purchase) {
        if (purchase == null) throw new NullPointerException();
        System.out.println("\nThe purchase is complete. The purchase amount was " + formatPrice(purchase.getPrice()));
    }

    public void run() {
        // Exercise 1: Publication's info
        Book bookFirst = new Book(25.50, 1000);
        Book bookSecond = new Book(50.70, 7500);
        Magazine magazine = new Magazine(11.50, 2000);

        System.out.println(bookFirst.toString());
        System.out.println(bookSecond.toString());
        System.out.println(magazine.toString());

        // Exercise 2: Equality
        System.out.println("\nReferential equality: " + (bookFirst == bookSecond));
        System.out.println("Structural equality: " + (bookFirst.equals(bookSecond)));

        // Exercise 3: Null safety (which doesn't exist ¯\_(ツ)_/¯)
        Book nullTestBookFirst = null;
        Book nullTestBookSecond = new Book(17.20, 500);

        try {
            buy(nullTestBookSecond);
            buy(nullTestBookFirst);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught.");
        }

        // Exercise 4: Lambda
        Operation sum = (x, y) -> x + y;
        System.out.println("\n27 + 17 = " + sum.calculate(27, 17));
    }
}
