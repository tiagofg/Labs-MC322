package br.unicamp.ic.mc322.lab12.engine;

import br.unicamp.ic.mc322.lab12.map.CheckPoint;
import br.unicamp.ic.mc322.lab12.map.Player;
import br.unicamp.ic.mc322.lab12.map.Wall;

public interface LabyrinthObjectVisitor {

    void visit(Player player);
    void visit(Wall wall);
    void visit(CheckPoint checkPoint);

}
