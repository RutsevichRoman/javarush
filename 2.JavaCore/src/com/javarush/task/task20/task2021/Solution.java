package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Запрет сериализации
*/
public class Solution implements Serializable {

    public static class SubSolution extends Solution {

        private void writeObject(ObjectOutputStream out) throws NotSerializableException {
            throw new NotSerializableException("Not serializeable");
        }

        private void readObject(ObjectInputStream in) throws NotSerializableException {
            throw new NotSerializableException("Not serializeable");
        }
    }



    public static void main(String[] args) {

    }
}
