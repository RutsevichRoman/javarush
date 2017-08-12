package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;

    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        Student student = null;
        for (Student s : students) {
            if (s.getAverageGrade() == averageGrade) {
                student = s;
                break;
            }
        }
        return student;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        if (!students.isEmpty()) {
            Student student = students.get(0);
            for (Student s : students) {
                if (student.getAverageGrade() < s.getAverageGrade()) {
                    student = s;
                }
            }
            return student;
        }
        return null;
    }

    public Student getStudentWithMinAverageGrade() {
        if (!students.isEmpty()) {
            Student stu = students.get(0);
            for (Student s : students) {
                if (stu.getAverageGrade() > s.getAverageGrade()) {
                    stu = s;
                }
            }
            return stu;
        }
        return null;
    }

    public void expel(Student student) {
        students.remove(student);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}