package com.javarush.task.task25.task2506;

/**
 * Created by Roman on 22.03.2017.
 */
public class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        this.thread.setDaemon(true);
    }

    @Override
    public void run() {
        super.run();
        State state = this.thread.getState();
        System.out.println(state);

        while (state != State.TERMINATED){
            if (state != this.thread.getState()) {
                state = this.thread.getState();
                System.out.println(state);
            }
        }
    }
}
