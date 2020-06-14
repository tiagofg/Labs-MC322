package br.unicamp.ic.mc322.lab12.engine;

import br.unicamp.ic.mc322.lab12.map.LabyrinthMap;

public abstract class GameEngine {

    private LabyrinthMap labyrinthMap;

    public GameEngine(LabyrinthMap labyrinthMap) {
        this.labyrinthMap = labyrinthMap;
    }

    protected LabyrinthMap getLabyrinthMap() {
        return labyrinthMap;
    }

    public abstract void gameLoop();

}
