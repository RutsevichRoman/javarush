package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {

        if (string.isEmpty()) {
            throw new TooShortStringException();
        }

        int spacesCount = 0;
        int endInd = 0;

        for (int i = 0; i < string.length(); i++) {
            char a = string.charAt(i);
            if (a == ' ') {
                spacesCount++;
                if (spacesCount == 4) {
                    endInd = string.length();
                } else if (spacesCount == 5) {
                    endInd = i;
                    break;
                }
            }
        }

        if (spacesCount < 4) {
            throw new TooShortStringException();
        }

        return string.substring(string.indexOf(" ") + 1, endInd);

    }

    public static class TooShortStringException extends RuntimeException {
    }
}
