package br.unicamp.ic.mc322.lab13.items;

public class BlankSpace extends Item {

    private static final String BLANK_SPACE = "--";

    public BlankSpace(Integer x, Integer y) {
        super(x, y);
    }

    @Override
    public boolean isOccupied() {
        return false;
    }

    @Override
    public boolean canCollect() {
        return false;
    }

    @Override
    public boolean canUseToRecharge() {
        return false;
    }

    @Override
    public Integer getEnergyPoints() {
        return 0;
    }

    @Override
    public void setEnergyPoints(Integer energyPoints) {

    }

    @Override
    public String toString() {
        return BLANK_SPACE;
    }
}
