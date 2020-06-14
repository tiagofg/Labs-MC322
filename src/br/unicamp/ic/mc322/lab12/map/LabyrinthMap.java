package br.unicamp.ic.mc322.lab12.map;

import br.unicamp.ic.mc322.lab12.engine.LabyrinthObjectVisitor;

import java.security.InvalidParameterException;
import java.util.List;

public class LabyrinthMap {

    private Integer width;
    private Integer height;
    private Player player;
    private List<CheckPoint> checkPoints;
    private List<Wall> walls;

    protected LabyrinthMap(Integer width, Integer height, Player player, List<CheckPoint> checkPoints, List<Wall> walls) {
        this.width = width;
        this.height = height;
        this.player = player;
        this.checkPoints = checkPoints;
        this.walls = walls;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public void updateMap(Direction direction) {
        if (direction == null) {
            throw new InvalidParameterException("A direção não pode ser nula");
        }

        player.move(direction, walls);

        for (CheckPoint checkPoint : checkPoints) {
            if (player.isSameCoordinates(checkPoint)) {
                checkPoint.conquer();
            }
        }
    }

    public Boolean isDone() {
        for (CheckPoint checkPoint : checkPoints) {
            if (!checkPoint.isConquered()) {
                return false;
            }
        }

        return true;
    }

    public void accept(LabyrinthObjectVisitor visitor) {
        for (Wall wall : walls) {
            wall.accept(visitor);
        }

        for (CheckPoint checkPoint : checkPoints) {
            checkPoint.accept(visitor);
        }

        player.accept(visitor);
    }

}
