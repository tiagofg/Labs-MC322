package br.unicamp.ic.mc322.lab13.items;

import br.unicamp.ic.mc322.lab13.map.Position;

public abstract class Item {

    private Position position;

    public Item(Integer x, Integer y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return position;
    }

    public Integer getX() {
        return position.getX();
    }

    public Integer getY() {
        return position.getY();
    }

    public abstract boolean isOccupied();

    public abstract boolean canCollect();

    public abstract boolean canUseToRecharge();

    public abstract Integer getEnergyPoints();

    public abstract void setEnergyPoints(Integer energyPoints);
}
