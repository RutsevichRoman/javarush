package com.javarush.task.task21.task2113;


import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private static List<Horse> horses;

    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) {

        Horse horse1 = new Horse("Billy", 3, 0);
        Horse horse2 = new Horse("Judy", 3, 0);
        Horse horse3 = new Horse("Kir", 3, 0);

        game = new Hippodrome(new ArrayList<>());

        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);

        game.run();
        game.printWinner();
    }

    public void run()  {

        for (int i = 1; i <= 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void move() {
        for (Horse h: getHorses()) {
            h.move();
        }
    }

    public void print() {
        for (Horse h: getHorses()) {
            h.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("");
        }
    }

    public Horse getWinner () {
        double max = 0.0;
        Horse winner = null;

        for (Horse h: getHorses()) {
            if (h.getDistance() > max) {
                max = h.getDistance();
            }
        }

        for (Horse h: getHorses()) {
            if (h.getDistance() == max) {
                winner = h;
            }
        }

        return winner;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public List<Horse> getHorses() {
        return horses;
    }
}
