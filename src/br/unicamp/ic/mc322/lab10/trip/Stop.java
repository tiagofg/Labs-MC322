package br.unicamp.ic.mc322.lab10.trip;

import br.unicamp.ic.mc322.lab10.users.Passenger;

import java.util.List;

public class Stop {

    private Integer place;
    private List<Passenger> passengersArriving;
    private List<Passenger> passengersLeaving;

    public Stop(Integer place) {
        this.place = place;
    }

    public Stop(Integer place, List<Passenger> passengersArriving, List<Passenger> passengersLeaving) {
        this.place = place;
        this.passengersArriving = passengersArriving;
        this.passengersLeaving = passengersLeaving;
    }

    public Integer getPlace() {
        return place;
    }

    public List<Passenger> getPassengersArriving() {
        return passengersArriving;
    }

    public List<Passenger> getPassengersLeaving() {
        return passengersLeaving;
    }

    public boolean hasPassengersArriving() {
        return passengersArriving != null;
    }

    public boolean hasPassengersLeaving() {
        return passengersLeaving != null;
    }

}
