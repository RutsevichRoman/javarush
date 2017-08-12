package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        String fileName = reader.readLine();
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();

        while (bufferedReader.ready()) {
            sb.append(bufferedReader.readLine());
        }

        bufferedReader.close();

        String tag = args[0];
        String str = sb.toString().replaceAll("\r\n","");

//        System.out.println(str);

        String openTag = "<" + tag;
        String closeTag = "</" + tag + ">";

        Pattern tagPattern = Pattern.compile("(<" + tag + ")|(</" + tag + ">)");
        Matcher tagMatcher = tagPattern.matcher(str);

        while (tagMatcher.find()) {
            if(openTag.equals(tagMatcher.group())) {
                stack.push(tagMatcher.start());
            } else if (closeTag.equals(tagMatcher.group())) {
                treeMap.put(stack.pop(),tagMatcher.end());
            }
        }

        for (Map.Entry<Integer, Integer> pair: treeMap.entrySet()) {
            list.add(str.substring(pair.getKey(),pair.getValue()));
        }

        for (String ss: list) {
            System.out.println(ss);
        }


    }
}
