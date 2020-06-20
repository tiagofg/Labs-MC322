package br.unicamp.ic.mc322.lab13.items;

public class BlankSpace implements Item {

    private static final String BLANK_SPACE = "--";

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
    public String toString() {
        return BLANK_SPACE;
    }
}
