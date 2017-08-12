package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

        Integer[] ar = new Integer[]{13, 8, 15, 5, 17};

        sort(ar);
//        for (int i = 0; i < ar.length; i++) {
//            System.out.print(ar[i] + " ");
//        }

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);

        double median;
        int mid = array.length / 2;
        if (array.length % 2 == 0) {
            median = ((double) array[mid - 1] + (double) array[mid]) / 2;
        } else {
            median = array[mid];
        }

        Comparator<Integer> compareByMedian = (o1, o2) -> {
            double value = Math.abs(o1 - median) - Math.abs(o2 - median);
            if (value == 0)
                value = o1 - o2;
            return (int)value;
        };

        Arrays.sort(array, compareByMedian);

        return array;
    }
}
