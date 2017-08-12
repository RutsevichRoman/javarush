package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = 31 * result;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            A a = (A) obj;
            if (a.i == 0 || a.j == 0) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        protected A clone() throws CloneNotSupportedException {
            int cI;

            if (this.getI() == 0) {
                cI = 0;
            } else {
                cI = this.getI();
            }

            int cJ;

            if (this.getJ() == 0) {
                cJ = 0;
            } else {
                cJ = this.getJ();
            }

            return new A(cI,cJ);
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B implements Cloneable{
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        private C duplicate(C c)
        {
            return new C(c.getI(), c.getJ(), c.getName());
        }

        @Override
        protected C clone() throws CloneNotSupportedException {
            return duplicate(this);
        }
    }

    public static void main(String[] args) {

    }
}
