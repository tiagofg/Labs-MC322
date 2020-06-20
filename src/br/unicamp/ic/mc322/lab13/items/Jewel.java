package br.unicamp.ic.mc322.lab13.items;

import br.unicamp.ic.mc322.lab13.enums.ColorEnum;

public class Jewel implements Item, Rechargeable {

    private ColorEnum color;
    private Integer energyPoints;

    public Jewel(ColorEnum color) {
        this.color = color;
        this.energyPoints = color.getEnergyPoints();
    }

    public Integer getScorePoints() {
        return color.getScorePoints();
    }

    @Override
    public boolean isOccupied() {
        return true;
    }

    @Override
    public boolean canCollect() {
        return true;
    }

    @Override
    public boolean canUseToRecharge() {
        return color.equals(ColorEnum.BLUE);
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
        return color.getCode();
    }

}
