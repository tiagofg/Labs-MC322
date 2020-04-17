package br.unicamp.ic.mc322.lab04;

import java.util.ArrayList;
import java.util.List;

public class Robot {

    private Position position;
    private List<Jewel> bag;

    public Robot(Integer x, Integer y) {
        this.position = new Position(x, y);
        this.bag = new ArrayList<>();
    }

    public Integer getX() {
        return position.getX();
    }

    public Integer getY() {
        return position.getY();
    }

    public void moveNorth() {
        position.decX();
    }

    public void moveSouth() {
        position.incX();
    }

    public void moveEast() {
        position.incY();
    }

    public void moveWest() {
        position.decY();
    }

    public void collectJewel(Jewel jewel) {
        this.bag.add(jewel);
    }

    private Integer getBagPoints() {
        Integer totalPoints = 0;

        for (Jewel jewel : bag) {
            totalPoints += jewel.getPoints();
        }

        return totalPoints;
    }

    public void printJewels() {
        System.out.println("Bag total items: " + bag.size() + " | Bag total values: " + getBagPoints());
    }
}
