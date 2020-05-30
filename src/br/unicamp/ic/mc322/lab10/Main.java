package br.unicamp.ic.mc322.lab10;

import br.unicamp.ic.mc322.lab10.trip.Stop;
import br.unicamp.ic.mc322.lab10.trip.Trip;
import br.unicamp.ic.mc322.lab10.trip.Vehicle;
import br.unicamp.ic.mc322.lab10.users.Driver;
import br.unicamp.ic.mc322.lab10.users.Passenger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Passenger marcos = new Passenger("Marcos",
                "145678798",
                LocalDate.of(1998, 7, 15),
                "369874");

        Vehicle deluxeVehicle = new Vehicle("ABC-1234", 2009, true);
        Vehicle commonVehicle = new Vehicle("OOP-2020", 2013, false);

        Driver maria = new Driver("Maria",
                "248679108",
                LocalDate.of(1997, 2, 12),
                "987654",
                "483530");

        maria.addVehicle(deluxeVehicle);
        maria.addVehicle(commonVehicle);

        Passenger joao = new Passenger("João",
                "654973652",
                LocalDate.of(2002, 1, 3),
                "785632");

        List<Passenger> passengersTripOne = new ArrayList<>();
        passengersTripOne.add(marcos);

        List<Stop> stopsTripOne = new ArrayList<>();
        stopsTripOne.add(new Stop(100));
        stopsTripOne.add(new Stop(300));

        Trip tripOne = new Trip(passengersTripOne, maria, deluxeVehicle, 500, stopsTripOne);

        tripOne.startTrip();
        tripOne.finishTrip();
        tripOne.printSummary();


        List<Passenger> passengersTripTwo = new ArrayList<>();
        passengersTripTwo.add(marcos);
        passengersTripTwo.add(joao);

        List<Passenger> passengersLeaving = new ArrayList<>();
        passengersLeaving.add(joao);

        List<Stop> stopsTripTwo = new ArrayList<>();
        stopsTripTwo.add(new Stop(100));
        stopsTripTwo.add(new Stop(300));
        stopsTripTwo.add(new Stop(500, null, passengersLeaving));
        stopsTripTwo.add(new Stop(1000));
        stopsTripTwo.add(new Stop(1500));

        Trip tripTwo = new Trip(passengersTripTwo, maria, commonVehicle, 2000, stopsTripTwo);

        tripTwo.startTrip();
        tripTwo.finishTrip();
        tripTwo.printSummary();


        List<Passenger> passengersTripThree = new ArrayList<>();
        passengersTripThree.add(joao);

        List<Stop> stopsTripThree = new ArrayList<>();
        stopsTripThree.add(new Stop(100));
        stopsTripThree.add(new Stop(300));
        stopsTripThree.add(new Stop(500));

        Trip tripThree = new Trip(passengersTripThree, maria, deluxeVehicle, 700, stopsTripThree);

        tripThree.startTrip();
        tripThree.finishTrip();
        tripThree.printSummary();

    }

}
