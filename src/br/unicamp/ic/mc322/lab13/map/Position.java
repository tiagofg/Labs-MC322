package br.unicamp.ic.mc322.lab13.map;

public class Position {

    private Integer x;
    private Integer y;

    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void incY() {
        y++;
    }

    public void decY() {
        y--;
    }

    public void incX() {
        x++;
    }

    public void decX() {
        x--;
    }
}
