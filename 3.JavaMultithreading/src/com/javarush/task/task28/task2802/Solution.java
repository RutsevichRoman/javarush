package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {
//    private volatile static AtomicInteger A = new AtomicInteger();
//    private volatile static AtomicInteger B = new AtomicInteger();

    public static void main(String[] args) {
        class EmulateThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulateThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulateThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = () -> System.out.println(Thread.currentThread().getName());
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {

        private volatile AtomicInteger poolNum = new AtomicInteger(0);
        private volatile AtomicInteger thNum = new AtomicInteger(1);
        static AtomicInteger count = new AtomicInteger(0);

        public AmigoThreadFactory() {
            poolNum.set(count.incrementAndGet());
        }

        @Override
        public Thread newThread(Runnable r) {

            Thread thread = new Thread(r);
            thread.setDaemon(false);
            thread.setPriority(Thread.NORM_PRIORITY);
            thread.setName(thread.getThreadGroup().getName() + "-pool-" + poolNum.intValue() + "-thread-" + thNum.intValue());
            thNum.incrementAndGet();
            return thread;
        }


//        @Override
//        public String toString() {
//            return thread.getThreadGroup().getName() + "-pool-" + A.intValue() + "-thread-" + B.intValue();
//        }
    }
}
