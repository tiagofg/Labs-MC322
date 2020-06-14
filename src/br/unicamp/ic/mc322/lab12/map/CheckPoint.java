package br.unicamp.ic.mc322.lab12.map;

import br.unicamp.ic.mc322.lab12.engine.LabyrinthObjectVisitor;

public class CheckPoint extends LabyrinthObject {

    private Boolean conquered;

    CheckPoint(Integer x, Integer y) {
        super(x, y);
        this.conquered = false;
    }

    public Boolean isConquered() {
        return conquered;
    }

    void conquer() {
        this.conquered = true;
    }

    @Override
    public void accept(LabyrinthObjectVisitor visitor) {
        visitor.visit(this);
    }

}
