package com.javarush.task.task25.task2504;

/*
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод

        for (int i = 0; i < threads.length; i++) {
            Thread thread = threads[i];
            switch (thread.getState()){
                case NEW:
                    thread.start();
                    break;
                case WAITING:
                    thread.interrupt();
                    break;
                case TIMED_WAITING:
                    thread.interrupt();
                    break;
                case BLOCKED:
                    thread.interrupt();
                    break;
                case RUNNABLE:
                    if (thread.isInterrupted()){
                        break;
                    }
                    break;
                case TERMINATED:
                    System.out.println(thread.getPriority());
                    break;
                default:
                    thread.interrupt();

            }
        }

    }

    public static void main(String[] args) {
    }
}
