package br.unicamp.ic.mc322.lab04;

import br.unicamp.ic.mc322.lab04.enums.ColorEnum;

public class Jewel {

    private Position position;
    private ColorEnum color;

    public Jewel(Integer x, Integer y, ColorEnum color) {
        this.position = new Position(x, y);
        this.color = color;
    }

    public Integer getX() {
        return position.getX();
    }

    public Integer getY() {
        return position.getY();
    }

    public String getColor() {
        return color.getName();
    }

    public Integer getPoints() {
        return color.getPoints();
    }
}
