package br.unicamp.ic.mc322.lab04;

import br.unicamp.ic.mc322.lab04.enums.ObstacleEnum;

public class Obstacle {

    private Position position;
    private ObstacleEnum obstacleType;

    public Obstacle(Integer x, Integer y, ObstacleEnum obstacleType) {
        this.position = new Position(x, y);
        this.obstacleType = obstacleType;
    }

    public Integer getX() {
        return position.getX();
    }

    public Integer getY() {
        return position.getY();
    }

    public String getType() {
        return obstacleType.getName();
    }
}
