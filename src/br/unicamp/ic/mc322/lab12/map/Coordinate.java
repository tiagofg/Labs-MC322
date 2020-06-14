package br.unicamp.ic.mc322.lab12.map;

public class Coordinate {

    private Integer x;
    private Integer y;

    public Coordinate(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void changeCoordinates(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Boolean isSameCoordinates(Integer x, Integer y) {
        return x.equals(this.x) && y.equals(this.y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Coordinate)) {
            return false;
        }

        Coordinate coordinate = (Coordinate) obj;

        return isSameCoordinates(coordinate.getX(), coordinate.getY());
    }
}
