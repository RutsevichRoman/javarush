package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword,  "Home", "same", "eop");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();

            int stX = 0;
            int stY = 0;
            int enX = 0;
            int enY = 0;

            char fistLet = chars[0];

            for (int j = 0; j < crossword.length; j++) {

                for (int k = 0; k < crossword[0].length; k++) {

                    if (crossword[j][k] == fistLet) {
                        stX = k;
                        stY = j;

                        for (int l = 1; l < chars.length; l++) {
                            //Up
                            if (stY - l >= 0 && crossword[stY - l][stX] == chars[l]) {
                                enX = stX;
                                enY = stY - l;
                                if (l == chars.length - 1) {
                                    Word w = new Word(words[i]);
                                    w.setStartPoint(stX, stY);
                                    w.setEndPoint(enX, enY);
                                    list.add(w);
                                }
                            }
                            //Down
                            else if (stY + l < crossword.length && crossword[stY + l][stX] == chars[l]) {
                                enX = stX;
                                enY = stY + l;
                                if (l == chars.length - 1) {
                                    Word w = new Word(words[i]);
                                    w.setStartPoint(stX, stY);
                                    w.setEndPoint(enX, enY);
                                    list.add(w);
                                }
                            }
                            //Forward
                            else if (stX + l < crossword.length && crossword[stY][stX + l] == chars[l]) {
                                enX = k + l;
                                enY = j;
                                if (l == chars.length - 1) {
                                    Word w = new Word(words[i]);
                                    w.setStartPoint(stX, stY);
                                    w.setEndPoint(enX, enY);
                                    list.add(w);
                                }
                            }
                            //Backward
                            else if (stX - l >= 0 && crossword[stY][stX - l] == chars[l]) {
                                enX = k - l;
                                enY = j;
                                if (l == chars.length - 1) {
                                    Word w = new Word(words[i]);
                                    w.setStartPoint(stX, stY);
                                    w.setEndPoint(enX, enY);
                                    list.add(w);
                                }
                            }
                            //DiagRightUp
                            else if (stX + l < crossword[0].length && stY - l >= 0 && crossword[stY - l][stX + l] == chars[l]) {
                                enX = k + l;
                                enY = j - l;
                                if (l == chars.length - 1) {
                                    Word w = new Word(words[i]);
                                    w.setStartPoint(stX, stY);
                                    w.setEndPoint(enX, enY);
                                    list.add(w);
                                }
                            }
                            //DiagRightDown
                            else if (stX + l < crossword[0].length && stY + l < crossword.length && crossword[stY + l][stX + l] == chars[l]) {
                                enX = k + l;
                                enY = j + l;
                                if (l == chars.length - 1) {
                                    Word w = new Word(words[i]);
                                    w.setStartPoint(stX, stY);
                                    w.setEndPoint(enX, enY);
                                    list.add(w);
                                }
                            }
                            //DiagLeftUp
                            else if (stX - l >= 0 && stY - l >= 0 && crossword[stY - l][stX - l] == chars[l]) {
                                enX = k - l;
                                enY = j - l;
                                if (l == chars.length - 1) {
                                    Word w = new Word(words[i]);
                                    w.setStartPoint(stX, stY);
                                    w.setEndPoint(enX, enY);
                                    list.add(w);
                                }
                            }
                            //DiagLeftDown
                            else if (stX - l >= 0 && stY + l < crossword.length && crossword[stY + l][stX - l] == chars[l]) {
                                enX = k - l;
                                enY = j + l;
                                if (l == chars.length - 1) {
                                    Word w = new Word(words[i]);
                                    w.setStartPoint(stX, stY);
                                    w.setEndPoint(enX, enY);
                                    list.add(w);
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(list);
        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
