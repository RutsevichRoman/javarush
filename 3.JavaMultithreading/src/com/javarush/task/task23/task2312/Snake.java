package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;
    private int x;
    private int y;

    public List<SnakeSection> getSections() {
        return sections;
    }

    public Snake(int x, int y) {
        sections = new ArrayList<>();
        sections.add(new SnakeSection(x, y));

        isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public int getX() {
        x = sections.get(0).getX();
        return x;
    }

    public int getY() {
        y = sections.get(0).getY();
        return y;
    }

    public void move() {

        if (!isAlive) {
            return;
        }

        if (direction == SnakeDirection.UP) {
            move(0, -1);
        } else if (direction == SnakeDirection.RIGHT) {
            move(1, 0);
        } else if (direction == SnakeDirection.DOWN) {
            move(0, 1);
        } else if (direction == SnakeDirection.LEFT) {
            move(-1, 0);
        }

    }

    public void checkBorders(SnakeSection head) {
        if (head.getY() < 0 || head.getY() > Room.game.getHeight()) {
            isAlive = false;
        } else if (head.getX() < 0 || head.getX() > Room.game.getWidth()) {
            isAlive = false;
        }
    }

    public void checkBody(SnakeSection head) {
        if (sections.contains(head)) {
            isAlive = false;
        }
    }

    public void move(int x, int y) {

    }

}
