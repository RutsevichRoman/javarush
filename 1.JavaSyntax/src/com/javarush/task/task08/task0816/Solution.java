package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {

    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("tallone", new Date("JUNE 1 1980"));
        map.put("allone", new Date("JUNE 1 1980"));
        map.put("lone", new Date("JUNE 1 1980"));
        map.put("one", new Date("JUNE 1 1980"));
        map.put("ne", new Date("JUNE 1 1980"));
        map.put("Salle", new Date("JUNE 1 1980"));
        map.put("Stlne", new Date("JUNE 1 1980"));
        map.put("Stal", new Date("JUNE 1 1980"));
        map.put("Stale", new Date("JUNE 1 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        map.entrySet().removeIf(pair -> pair.getValue().getMonth() > 4 && pair.getValue().getMonth() < 8);
    }

    public static void main(String[] args) {
        removeAllSummerPeople(createMap());
    }
}
