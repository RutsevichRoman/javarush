package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        while (reader.ready()) {
            String s = reader.readLine();
            list.addAll(Arrays.asList(s.split(" ")));
        }

        String[] strs = new String[list.size()];
        strs = list.toArray(strs);

        StringBuilder builder = getLine(strs);
        System.out.println(builder.toString());

        reader.close();
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();

        if (words == null || words.length == 0) {
            return sb;
        }


        List<String> list = new ArrayList<>();


        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(""))
                list.add(words[i]);
        }

        while (!order(list)) {
            Collections.shuffle(list);
        }

        for (String s : list) {
            sb.append(s).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb;
    }

    public static boolean order(List<String> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            String prev = list.get(i).toLowerCase();
            String post = list.get(i + 1).toLowerCase();
            if (prev.charAt(prev.length() - 1) != post.charAt(0)) {
                return false;
            }
        }
        return true;
    }
}
