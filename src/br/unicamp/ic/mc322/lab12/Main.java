package br.unicamp.ic.mc322.lab12;

import br.unicamp.ic.mc322.lab12.engine.GameEngine;
import br.unicamp.ic.mc322.lab12.engine.TextEngine;
import br.unicamp.ic.mc322.lab12.map.LabyrinthMap;
import br.unicamp.ic.mc322.lab12.map.LabyrinthMapLoader;

public class Main {

    private static void runGame(GameEngine gameEngine) {
        gameEngine.gameLoop();
    }

    public static void main(String[] args) {
        LabyrinthMap map = LabyrinthMapLoader.getInstance().createDefaultMap();

        runGame(new TextEngine(map));
    }

}
