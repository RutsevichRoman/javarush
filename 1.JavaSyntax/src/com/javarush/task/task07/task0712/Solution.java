package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }

        int min = list.get(0).length();
        int max = list.get(0).length();
        int count = 0;
        int count1 = 0;
        for (int i = 0; i < list.size(); i++) {
            if (min > list.get(i).length()) {
                min = list.get(i).length();
                count = i;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i).length()) {
                max = list.get(i).length();
                count1 = i;
            }
        }
        if (count < count1) {
            System.out.println(list.get(count));
        } else System.out.println(list.get(count1));

    }
}
