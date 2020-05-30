package br.unicamp.ic.mc322.lab10.trip;

import br.unicamp.ic.mc322.lab10.users.Driver;
import br.unicamp.ic.mc322.lab10.users.Passenger;

import java.util.ArrayList;
import java.util.List;

public class Trip {

    private static final Double COMMON_VEHICLE_FIXED_PRICE = 3.00;
    private static final Double DELUXE_VEHICLE_FIXED_PRICE = 7.00;

    private static final Double COMMON_VEHICLE_HUNDRED_METERS_PRICE = 2.00;
    private static final Double DELUXE_VEHICLE_HUNDRED_METERS_PRICE = 3.50;

    private static final Double COMMON_VEHICLE_STOP_PRICE = 1.50;
    private static final Double DELUXE_VEHICLE_STOP_PRICE = 2.70;

    private List<PassengerInfo> passengers;
    private Driver driver;
    private Vehicle vehicle;
    private Integer distance;
    private List<Stop> stops;

    public Trip(List<Passenger> passengers, Driver driver, Vehicle vehicle, Integer distance, List<Stop> stops) {
        this.driver = driver;
        this.vehicle = vehicle;
        this.distance = distance;
        this.stops = stops;
        this.passengers = addPassengersInfo(passengers);
    }

    private List<PassengerInfo> addPassengersInfo(List<Passenger> passengers) {
        List<PassengerInfo> passengersInfo = new ArrayList<>();

        for (Passenger passenger: passengers) {
            passengersInfo.add(new PassengerInfo(passenger, distance));
        }

        return passengersInfo;
    }

    private void addPassengers(Stop stop) {
        if (stop.hasPassengersArriving()) {
            for (Passenger newPassenger: stop.getPassengersArriving()) {
                passengers.add(new PassengerInfo(newPassenger, stop.getPlace(), distance));
            }
        }
    }

    private PassengerInfo findPassengerInfo(Passenger passenger) {
        for (PassengerInfo info: passengers) {
            if (info.getPassenger().equals(passenger)) {
                return info;
            }
        }

        return null;
    }

    private void removePassengers(Stop stop) {
        if (stop.hasPassengersLeaving()) {
            for (Passenger passengerLeaving: stop.getPassengersLeaving()) {
                PassengerInfo info = findPassengerInfo(passengerLeaving);

                if (info != null) {
                    info.setEnd(stop.getPlace());
                    info.finishTrip();
                }
            }
        }
    }

    private void addStops() {
        for (PassengerInfo passengerInfo: passengers) {
            if (!passengerInfo.hasFinishedTrip()) {
                passengerInfo.addStop();
            }
        }
    }

    public void startTrip() {
        for (Stop stop: stops) {
            addStops();
            addPassengers(stop);
            removePassengers(stop);
        }
    }

    public void finishTrip() {
        calculatePrices();
    }

    private void calculatePrices() {
        for (PassengerInfo passenger: passengers) {
            passenger.setPrice(calculatePrice(vehicle.isDeluxe(), passenger.getEnd() - passenger.getBegin(), passenger.getNumberOfStops()));
        }
    }

    private Double calculatePrice(boolean deluxeCar, Integer distance, Integer numberOfStops) {
        Double price;

        if (deluxeCar) {
            price = DELUXE_VEHICLE_FIXED_PRICE +
                    (Math.floor(distance / 100.00) * DELUXE_VEHICLE_HUNDRED_METERS_PRICE) +
                    numberOfStops * DELUXE_VEHICLE_STOP_PRICE;
        } else {
            price = COMMON_VEHICLE_FIXED_PRICE +
                    (Math.floor(distance / 100.00) * COMMON_VEHICLE_HUNDRED_METERS_PRICE) +
                    numberOfStops * COMMON_VEHICLE_STOP_PRICE;
        }

        return price;
    }

    public void printSummary() {
        System.out.println("Informações da viagem: ");

        System.out.println("Motorista: ");
        System.out.println(driver + "\n");

        System.out.println("Veículo: ");
        System.out.println(vehicle + "\n");

        System.out.println("Distância total percorrida: ");
        System.out.println(distance + " m \n");

        System.out.println("Passageiros: ");

        for (PassengerInfo info: passengers) {
            System.out.println(info + "\n");
        }

        System.out.println("\n");

    }
}
