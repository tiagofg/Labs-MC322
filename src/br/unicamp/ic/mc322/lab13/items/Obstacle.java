package br.unicamp.ic.mc322.lab13.items;

import br.unicamp.ic.mc322.lab13.enums.ObstacleEnum;

public class Obstacle extends Item {

    private ObstacleEnum obstacleType;
    private Integer energyPoints;

    public Obstacle(Integer x, Integer y, ObstacleEnum obstacleType) {
        super(x, y);
        this.obstacleType = obstacleType;
        this.energyPoints = obstacleType.getEnergyPoints();
    }

    public ObstacleEnum getObstacleType() {
        return obstacleType;
    }

    @Override
    public boolean isOccupied() {
        return true;
    }

    @Override
    public boolean canCollect() {
        return false;
    }

    @Override
    public boolean canUseToRecharge() {
        return obstacleType.equals(ObstacleEnum.TREE);
    }

    @Override
    public Integer getEnergyPoints() {
        return energyPoints;
    }

    @Override
    public void setEnergyPoints(Integer energyPoints) {
        this.energyPoints = energyPoints;
    }

    @Override
    public String toString() {
        return obstacleType.getCode();
    }
}
