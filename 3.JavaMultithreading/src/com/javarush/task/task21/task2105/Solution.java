package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (first != null ? first.hashCode() : 0) + (last != null ? last.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (this.first == null || this.last == null) {
            return false;
        }

        if (!(o instanceof Solution))
            return false;

        Solution n = (Solution) o;

        if (n.first == null) {
            return false;
        }
        if (n.last == null) {
            return false;
        }

        if (!first.equals(n.first))
            return false;

        if (!last.equals(n.last))
            return false;

        if (this.first.equals(n.first) && this.last.equals(n.last))
            return true;

        return false;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
