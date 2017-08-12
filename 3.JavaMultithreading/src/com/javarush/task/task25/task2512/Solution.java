package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.List;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        List<Throwable> throwableList = new ArrayList<>();
        t.interrupt();

        Throwable throwable = e;
        throwableList.add(0, e);
        while (throwable.getCause() != null) {
            throwable = throwable.getCause();
            throwableList.add(0, throwable);
        }

        for (Throwable thr : throwableList) {
            System.out.println(thr.getClass().getName() + ": " + thr.getMessage());
        }
    }

    public static void main(String[] args) {
        Throwable e = new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        new Solution().uncaughtException(Thread.currentThread(), e);
    }
}
