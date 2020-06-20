package br.unicamp.ic.mc322.lab13.items;

public interface Item {

    boolean isOccupied();

    boolean canCollect();

    boolean canUseToRecharge();
}
