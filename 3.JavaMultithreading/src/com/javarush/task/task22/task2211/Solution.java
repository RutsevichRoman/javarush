package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        String fileIn = args[0];
        String fileOut = args[1];

        FileInputStream reader = new FileInputStream(fileIn);
        FileOutputStream writer = new FileOutputStream(fileOut);

        byte[] bytes = new byte[reader.available()];

        reader.read(bytes);

        String str = new String(bytes, "UTF-8");
        bytes = str.getBytes("Windows-1251");
        writer.write(bytes);

        reader.close();
        writer.close();
    }
}
