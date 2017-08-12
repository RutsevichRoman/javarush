package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        int sum  = 0;
        double arihmetic = 0;
        while (i != -1){
            String s = read.readLine();
            i = Integer.parseInt(s);
            if (i == -1) {
                arihmetic = arihmetic / sum;
                break;
            }
            else {
                arihmetic = arihmetic + i;
                sum++;
            }
        }
        System.out.println(arihmetic);
    }
}

