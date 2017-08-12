package com.javarush.task.task05.task0515;

/* 
Инициализация объектов
*/

public class Person {
    String name;
    char sex;
    int money;
    int weight;
    double size;

//    public void initialize(String name) {
//        this.name = name;
//    }
//
//    public void initialize(String name, char sex) {
//        this.name = name;
//        this.sex = sex;
//    }

    public void initialize(String name, int weight, double size, int money, char sex) {
        this.name = name;
        this.weight = weight;
        this.size = size;
        this.money = money;
        this.sex = sex;
    }

    public static void main(String[] args) {

    }
}
