package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {

        if (string == null || string.isEmpty()) throw new TooShortStringException();

        int tab1 = string.indexOf("\t");

        char[] chars = string.toCharArray();

        int tabCount = 0;
        int endInd = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\t') {
                tabCount++;
                if (tabCount == 2) {
                    endInd = i;
                    break;
                }
            }
        }

        if (tabCount < 2) {
            throw new TooShortStringException();
        }

        return string.substring(tab1 + 1, endInd);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
