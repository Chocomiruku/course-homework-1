package com.chocomiruku.homework3;

import com.chocomiruku.homework3.task1.FirstTask;
import com.chocomiruku.homework3.task2.SecondTask;


public class Main {

    public static void main(String[] args) {
        FirstTask firstTask = new FirstTask();
        SecondTask secondTask = new SecondTask();

        firstTask.run();
        secondTask.run();
    }
}