package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number1 =  reader.readLine();
        int a = Integer.parseInt(number1);

        String number2 =  reader.readLine();
        int b = Integer.parseInt(number2);

        String number3 =  reader.readLine();
        int c = Integer.parseInt(number3);
        int x;

        if (a==b && b==c && a==c)
        {
            System.out.println(a+" "+b+" "+ c);
        }
        else if((a==b)&&(c!=a)&&(c!=b))
        {
            System.out.println(a+" "+b);
        }
        else if ((a==c)&&(b!=a)&&(b!=c))
        {
            System.out.println(a + " " + c);
        }
        else if ((b==c)&&(a!=c)&&(a!=b))
        {
            System.out.println(b + " " + c);
        }
    }
}