package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable {
    protected Map<String, User> users = new LinkedHashMap<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31*result + (this.users != null ? this.users.hashCode() : 0);
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

        Solution s = (Solution) obj;

        if (s.users == null) {
            return false;
        }

        if (s.users == this.users) {
            return true;
        }
        return false;
    }

    @Override
    protected Solution clone() throws CloneNotSupportedException {
        Solution s = (Solution) super.clone();

        LinkedHashMap<String, User> cUsers = new LinkedHashMap<>();

        for (Map.Entry<String, User> pair : this.users.entrySet()) {

            if (pair.getKey() == null && pair.getValue() == null) {
                cUsers.put(null, null);
            }
            if (pair.getKey() != null && pair.getValue() == null) {
                String cName = pair.getKey();
                cUsers.put(cName, null);
            }
            if (pair.getKey() == null && pair.getValue() != null) {
                User cUser = pair.getValue();
                cUsers.put(null, cUser);
            }
            if (pair.getKey() != null && pair.getValue() != null) {
                String cName = pair.getKey();
                User cUser = pair.getValue();
                cUsers.put(cName, cUser);
            }
        }

        this.users = cUsers;

        return s;
    }

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
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

            User user = (User) obj;

            if (this.age == user.age && this.name.equals(user.name)) {
                return true;
            }

            return false;
        }

        @Override
        protected User clone() throws CloneNotSupportedException {

            int cAge;
            if (this.age == 0) {
                cAge = 0;
            } else {
                cAge = this.age;
            }

            String cName;
            if (this.name == null) {
                cName = null;
            } else {
                cName = this.name;
            }

            return new User(cAge, cName);
        }
    }
}
