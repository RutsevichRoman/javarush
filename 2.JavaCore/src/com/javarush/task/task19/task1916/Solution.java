package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file1));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();


        while (bufferedReader1.ready()) {
            list1.add(bufferedReader1.readLine());
        }

        while (bufferedReader2.ready()) {
            list2.add(bufferedReader2.readLine());
        }

        bufferedReader1.close();
        bufferedReader2.close();

        for (int i = 0; i < list1.size(); i++) {
            String s = list1.get(i);
            String ss = list2.get(i);

            if (s.equals(ss)) {
                lines.add(new LineItem(Type.SAME, s));
            } else if (!s.equals(ss) && ss.equals(Type.REMOVED.toString())) {
                lines.add(new LineItem(null, s));
            } else if (!s.equals(ss) && ss.equals(Type.ADDED.toString())) {
                lines.add(new LineItem(null, s));
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
