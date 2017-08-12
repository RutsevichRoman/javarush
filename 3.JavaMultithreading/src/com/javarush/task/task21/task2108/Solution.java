package com.javarush.task.task21.task2108;

import sun.font.TextRecord;

import java.util.Arrays;

/*
Клонирование растений
*/
public class Solution implements Cloneable {
    public static void main(String[] args) {
//        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree tree = new Tree("willow", null);
        Tree clone = null;
        try {
            clone = (Tree) tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant {
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }



        @Override
        protected Tree clone() throws CloneNotSupportedException {

            String[] brnchs;
            if (this.getBranches() == null) {
                brnchs = null;
            } else {
                brnchs = this.getBranches().clone();
            }

            String cName;
            if (this.getName() == null) {
                cName = null;
            } else {
                cName = this.getName();
            }

            return new Tree(cName, brnchs);
        }
    }
}
