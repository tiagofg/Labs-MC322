package br.unicamp.ic.mc322.lab12.map;

import java.util.ArrayList;
import java.util.List;

public class LabyrinthMapLoader {

    private static LabyrinthMapLoader instance;

    private LabyrinthMapLoader() {
    }

    public static LabyrinthMapLoader getInstance() {
        if (instance == null) {
            instance = new LabyrinthMapLoader();
        }

        return instance;
    }

    public LabyrinthMap createDefaultMap() {
        Player player = new Player(0, 0);

        List<CheckPoint> checkPoints = new ArrayList<>();
        CheckPoint firstCheckpoint = new CheckPoint(1, 1);
        checkPoints.add(firstCheckpoint);
        CheckPoint secondCheckpoint = new CheckPoint(2, 2);
        checkPoints.add(secondCheckpoint);
        CheckPoint thirdCheckpoint = new CheckPoint(3, 3);
        checkPoints.add(thirdCheckpoint);

        List<Wall> walls = new ArrayList<>();
        Wall firstWall = new Wall(0, 1);
        walls.add(firstWall);
        Wall secondWall = new Wall(1, 2);
        walls.add(secondWall);
        Wall thirdWall = new Wall(2, 3);
        walls.add(thirdWall);

        return new LabyrinthMap(
                5,
                5,
                player,
                checkPoints,
                walls
        );
    }
}
