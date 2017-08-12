package com.javarush.task.task09.task0918;

/* 
Все свои, даже исключения
*/

import java.io.IOException;
import java.sql.SQLException;

public class Solution {
    public static void main(String[] args) {
    }
    
    static class MyException extends SQLException{
    }

    static class MyException2 extends IOException{
    }

    static class MyException3 extends RuntimeException{
    }

    static class MyException4 extends NullPointerException{
    }
}

