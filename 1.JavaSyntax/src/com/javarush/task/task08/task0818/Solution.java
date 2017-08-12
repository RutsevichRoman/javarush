package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 400);
        map.put("S", 400);
        map.put("F", 400);
        map.put("G", 400);
        map.put("g", 400);
        map.put("h", 400);
        map.put("j", 400);
        map.put("Ik", 400);
        map.put("Il", 400);
        map.put("Im", 400);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            if ((int) pair.getValue() < 500)
                iterator.remove();
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> lohi = createMap();
        removeItemFromMap(lohi);
        for (Map.Entry<String, Integer> entry : lohi.entrySet()) {
            String Key = entry.getKey();
            Integer val = entry.getValue();
//            System.out.println(Key + " " + val);
        }
    }
}