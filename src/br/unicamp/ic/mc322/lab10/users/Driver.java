package br.unicamp.ic.mc322.lab10.users;

import br.unicamp.ic.mc322.lab10.trip.Vehicle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Driver extends User {

    private String driverLicense;
    private String creditCard;
    private List<Vehicle> vehicles;

    public Driver(String name, String cpf, LocalDate birthDate, String driverLicense, String creditCard) {
        super(name, cpf, birthDate);
        this.driverLicense = driverLicense;
        this.creditCard = creditCard;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicle.setOwner(this);

        vehicles.add(vehicle);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", CNH: " + driverLicense +
                ", cartão de crédito: " + creditCard;
    }
}
