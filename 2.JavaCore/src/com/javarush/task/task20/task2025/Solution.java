package com.javarush.task.task20.task2025;

import java.util.ArrayList;

/*
Алгоритмы-числа
*/
public class Solution {
//    public static long[] getNumbers(long N) {
//        long[] result = null;
//        return result;
//    }

    public static void main(String[] args) {
        int number = 1000000;
        long freeMemory = Runtime.getRuntime().freeMemory();
        long startTime = System.currentTimeMillis();
        long[] a = getNumbers(number);
        long memoryAfterCalculate = Runtime.getRuntime().freeMemory();
        long delta = memoryAfterCalculate - freeMemory;
        long stopTime = System.currentTimeMillis();
        System.out.println("Calculating time: " + (stopTime - startTime));
        System.out.println("Used JVM memory: " + delta);
        for (long i : a) {
            System.out.println(i);
        }
    }

    public static long[] getNumbers(long N) {
        ArrayList<Integer> longs = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            if (check(i))
                longs.add(i);
        }
        long[] result = new long[longs.size()];
        for (int i = 0; i < longs.size(); i++) {
            result[i] = longs.get(i);
        }
        return result;
    }

    public static boolean check(int number) {
        if (number == 0)
            return false;

        else if (number >= 1 && number < 10)
            return true;

        int rest = number,
                sum = 0,
                digit = 0,
                digitCount = 1 + (int) Math.log10(number);
//        System.out.println("log10 = " + digitCount);
        for (int i = 0; i < digitCount; i++) {
            digit = rest % 10;
//            System.out.println("digit = " + digit);
            rest = rest / 10;
//            System.out.println("rest = " + rest);
            int prod = digit;
            for (int j = 1; j < digitCount; j++) {
                prod *= digit;
            }
            sum += prod;
        }
        if (sum == number)
            return true;
        else
            return false;
    }
}
