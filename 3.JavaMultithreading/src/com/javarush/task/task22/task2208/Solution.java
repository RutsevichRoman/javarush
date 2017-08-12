package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();

        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);

        System.out.println(getQuery(map));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> pair: params.entrySet()) {
            if (pair.getValue() != null){
                stringBuilder.append(pair.getKey()).append(" = '").append(pair.getValue()).append("' and ");
            }
        }

        if (stringBuilder.length() > 0) {
            stringBuilder.replace(stringBuilder.length() - 5, stringBuilder.length(), "");
        }

        return stringBuilder.toString();
    }
}
