package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(new Solution(4));

        String fileName = "C:\\Users\\Roman\\Desktop\\file1.txt";
        InputStream inputStream = new FileInputStream(fileName);
        OutputStream outputStream = new FileOutputStream(fileName);

        Solution savedOnject = new Solution();
//        outputStream(savedOnject);
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution() {

    }

    public Solution(int temperature) {

        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }


    @Override
    public String toString() {
        return this.string;
    }
}
