package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        int tmp = -1;
        int jt = a[0].length;
        boolean findRec = false;

//        System.out.println(jt);

        while (tmp != count) {
            tmp = count;

            outLoop:
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    if (a[i][j] == 1 && !findRec) {
                        count++;
                        jt = j;
                        findRec = true;
                        a[i][j] = 0;
                    } else if (a[i][j] == 1 && findRec) {
                        a[i][j] = 0;
                    } else if (a[i][j] == 0 && findRec && j == jt) {
                        break outLoop;
                    } else if (a[i][j] == 0 && findRec && j > jt) {
                        break;
                    }
                }
            }
            findRec = false;
        }
        return count;
    }

}
