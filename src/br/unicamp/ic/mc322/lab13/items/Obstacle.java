package br.unicamp.ic.mc322.lab13.items;

import br.unicamp.ic.mc322.lab13.enums.ObstacleEnum;

public class Obstacle implements Item, Rechargeable {

    private ObstacleEnum obstacleType;
    private Integer energyPoints;

    public Obstacle(ObstacleEnum obstacleType) {
        this.obstacleType = obstacleType;
        this.energyPoints = obstacleType.getEnergyPoints();
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
    public void resetEnergyPoints() {
        this.energyPoints = 0;
    }

    @Override
    public String toString() {
        return obstacleType.getCode();
    }
}
