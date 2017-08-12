package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        String c = reader.readLine();
        int a1 = Integer.parseInt(a);
        int b1 = Integer.parseInt(b);
        int c1 = Integer.parseInt(c);
        if (a1 < b1+c1 && b1 < a1+c1 && c1 < a1+b1)
        {
            System.out.println("Треугольник существует.");
        }
        else
        {
            System.out.println("Треугольник не существует.");
        }
    }
}