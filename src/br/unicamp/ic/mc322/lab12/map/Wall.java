package br.unicamp.ic.mc322.lab12.map;

import br.unicamp.ic.mc322.lab12.engine.LabyrinthObjectVisitor;

public class Wall extends LabyrinthObject {

    public Wall(Integer x, Integer y) {
        super(x, y);
    }

    @Override
    public void accept(LabyrinthObjectVisitor visitor) {
        visitor.visit(this);
    }

}
