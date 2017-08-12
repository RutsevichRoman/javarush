package com.javarush.task.task20.task2009;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable{
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public void serializeStatic(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeBytes(staticString);
        }

        public void deserializeStatic(ObjectInputStream objectInputStream) throws IOException {
//            staticString = objectInputStream.re;

            while (objectInputStream.available() > 0) {
                staticString.concat(String.valueOf(objectInputStream.read()));
            }
        }
    }

    public static void main(String[] args) {

    }
}
