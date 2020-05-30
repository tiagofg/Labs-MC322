package br.unicamp.ic.mc322.lab10.trip;

import br.unicamp.ic.mc322.lab10.users.Driver;

public class Vehicle {

    private String plate;
    private Integer fabricationYear;
    private boolean deluxe;
    private Driver owner;

    public Vehicle(String plate, Integer fabricationYear, boolean deluxe) {
        this.plate = plate;
        this.fabricationYear = fabricationYear;
        this.deluxe = deluxe;
    }

    public boolean isDeluxe() {
        return deluxe;
    }

    public void setOwner(Driver owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Placa: " + plate +
                ", ano de fabricação: " + fabricationYear +
                ", de luxo: " + (deluxe ? "sim" : "não") +
                ", dono(a): " + owner.getName();
    }
}
