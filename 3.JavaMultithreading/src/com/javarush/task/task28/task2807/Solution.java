package com.javarush.task.task28.task2807;

import java.sql.Time;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Знакомство с ThreadPoolExecutor
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here

        LinkedBlockingQueue<Runnable> runnables = new LinkedBlockingQueue<>();
        AtomicInteger atomicInteger = new AtomicInteger(1);

        for (int i = 0; i < 10; i++) {
            runnables.add(() -> doExpensiveOperation(atomicInteger.getAndIncrement()));
        }

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3,5,1000, TimeUnit.MILLISECONDS, runnables);

        poolExecutor.prestartAllCoreThreads();

        poolExecutor.shutdown();

        poolExecutor.awaitTermination(5, TimeUnit.SECONDS);
                ;
        /* output example
pool-1-thread-2, localId=2
pool-1-thread-3, localId=3
pool-1-thread-1, localId=1
pool-1-thread-3, localId=5
pool-1-thread-2, localId=4
pool-1-thread-3, localId=7
pool-1-thread-1, localId=6
pool-1-thread-3, localId=9
pool-1-thread-2, localId=8
pool-1-thread-1, localId=10
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}
