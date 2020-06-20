package br.unicamp.ic.mc322.lab13.items;

import br.unicamp.ic.mc322.lab13.enums.ColorEnum;

public class Jewel extends Item {

    private ColorEnum color;
    private Integer energyPoints;

    public Jewel(Integer x, Integer y, ColorEnum color) {
        super(x, y);
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
    public void setEnergyPoints(Integer energyPoints) {
        this.energyPoints = energyPoints;
    }

    @Override
    public String toString() {
        return color.getCode();
    }

}
