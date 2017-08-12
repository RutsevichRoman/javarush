package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Roman on 01.06.2017.
 */
public class MyThread extends Thread {

    public static AtomicInteger count = new AtomicInteger(Thread.MIN_PRIORITY);

    public MyThread() {

        if (count.get() <= Thread.MAX_PRIORITY) {
            setPriority(count.getAndIncrement());
        } else {
            count.set(Thread.MIN_PRIORITY);
            setPriority(count.getAndIncrement());
        }

//        if (count.get() < 10){
//            setPriority(count.getAndIncrement());
//        }
//        else {
//            setPriority(count.get());
//            count.set(1);
//        }
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if (count.get() < group.getMaxPriority()) {
            setPriority(count.getAndIncrement());
        } else if (count.getAndIncrement() <= Thread.MAX_PRIORITY){
            setPriority(group.getMaxPriority());
        } else {
            count.set(Thread.MIN_PRIORITY);
            setPriority(count.getAndIncrement());
        }

    }

    public MyThread(Runnable target) {
        super(target);
        if (count.get() <= Thread.MAX_PRIORITY) {
            setPriority(count.getAndIncrement());
        } else {
            count.set(Thread.MIN_PRIORITY);
            setPriority(count.getAndIncrement());
        }
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);

        if (count.get() < group.getMaxPriority()) {
            setPriority(count.getAndIncrement());
        } else if (count.getAndIncrement() <= Thread.MAX_PRIORITY){
            setPriority(group.getMaxPriority());
        } else {
            count.set(Thread.MIN_PRIORITY);
            setPriority(count.getAndIncrement());
        }
    }

    public MyThread(String name) {
        super(name);
        if (count.get() <= Thread.MAX_PRIORITY) {
            setPriority(count.getAndIncrement());
        } else {
            count.set(Thread.MIN_PRIORITY);
            setPriority(count.getAndIncrement());
        }
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        if (count.get() <= Thread.MAX_PRIORITY) {
            setPriority(count.getAndIncrement());
        } else {
            count.set(Thread.MIN_PRIORITY);
            setPriority(count.getAndIncrement());
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);

        if (count.get() < group.getMaxPriority()) {
            setPriority(count.getAndIncrement());
        } else if (count.getAndIncrement() <= Thread.MAX_PRIORITY){
            setPriority(group.getMaxPriority());
        } else {
            count.set(Thread.MIN_PRIORITY);
            setPriority(count.getAndIncrement());
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);

        if (count.get() < group.getMaxPriority()) {
            setPriority(count.getAndIncrement());
        } else if (count.getAndIncrement() <= Thread.MAX_PRIORITY){
            setPriority(group.getMaxPriority());
        } else {
            count.set(Thread.MIN_PRIORITY);
            setPriority(count.getAndIncrement());
        }
    }
}
