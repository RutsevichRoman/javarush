package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;

//    public static final BloodGroup FIRST = BloodGroup.first();
//    public static final BloodGroup SECOND = BloodGroup.second();
//    public static final BloodGroup THIRD = BloodGroup.third();
//    public static final BloodGroup FOURTH = BloodGroup.fourth();

    protected Size size;

    private List<Human> children = new ArrayList<>();

    private BloodGroup bloodGroup;


    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void live() {

    }

    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public void removeChild(Human child) {
        children.remove(child);
    }

    public String getPosition() {
        return "Человек";
    }

    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public class Size {
        public int height;
        public int weight;

//        public Size(int heigth, int weigth) {
//            this.height = heigth;
//            this.weight = weigth;
//        }
//
//        public int getHeight() {
//            return height;
//        }
//
//        public int getWeight() {
//            return weight;
//        }
    }
}