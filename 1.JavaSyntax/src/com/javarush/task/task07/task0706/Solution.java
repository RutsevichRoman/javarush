package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int r = 0;
        int l = 0;
        int[] list = new int[15];
//        int a = list.length - 1;
        for (int i = 0; i < list.length; i++) {
            String s = reader.readLine();
            list[i] = Integer.parseInt(s);
        }
        for (int a = list.length - 1; a >= 0; a--) {
            if (a == 0 || a % 2 == 0)  //не могу понять, как узнать четный и не четный индекс элемента!
            {
                r += list[a];
            } else if (list.length % 2 != 0) {
                l += list[a];
            }
        }
        if (r > l)
            System.out.println("В домах с четными номерами проживает больше жителей.");
        else
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
