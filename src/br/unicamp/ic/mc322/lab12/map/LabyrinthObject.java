package br.unicamp.ic.mc322.lab12.map;

import br.unicamp.ic.mc322.lab12.engine.LabyrinthObjectVisitor;

public abstract class LabyrinthObject {

    private Coordinate coordinate;

    LabyrinthObject(Integer x, Integer y) {
        this.coordinate = new Coordinate(x, y);
    }

    public Integer getX() {
        return coordinate.getX();
    }

    public Integer getY() {
        return coordinate.getY();
    }

    protected Coordinate getCoordinate() {
        return coordinate;
    }

    public Boolean isSameCoordinates(Integer x, Integer y) {
        return coordinate.isSameCoordinates(x, y);
    }

    public Boolean isSameCoordinates(LabyrinthObject labyrinthObject) {
        return coordinate.equals(labyrinthObject.getCoordinate());
    }

    public abstract void accept(LabyrinthObjectVisitor visitor);

}
