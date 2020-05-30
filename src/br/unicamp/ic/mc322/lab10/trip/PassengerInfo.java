package br.unicamp.ic.mc322.lab10.trip;

import br.unicamp.ic.mc322.lab10.users.Passenger;

import java.text.NumberFormat;
import java.util.Locale;

public class PassengerInfo {

    private Passenger passenger;
    private Integer begin;
    private Integer end;
    private Double price;
    private Integer numberOfStops;
    private boolean finishedTrip;

    public PassengerInfo(Passenger passenger, Integer end) {
        this.passenger = passenger;
        this.begin = 0;
        this.end = end;
        this.numberOfStops = 0;
        this.finishedTrip = false;
    }

    public PassengerInfo(Passenger passenger, Integer begin, Integer end) {
        this.passenger = passenger;
        this.begin = begin;
        this.end = end;
        this.numberOfStops = 0;
        this.finishedTrip = false;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Integer getBegin() {
        return begin;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumberOfStops() {
        return numberOfStops;
    }

    public boolean hasFinishedTrip() {
        return finishedTrip;
    }

    public void addStop() {
        numberOfStops++;
    }

    public void finishTrip() {
        this.finishedTrip = true;
    }

    @Override
    public String toString() {
        NumberFormat formatToReal = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        return "Passageiro: (" + passenger + ") \n" +
                "Início da viagem: " + begin + "m \n" +
                "Fim da viagem: " + end + "m \n" +
                "Preço: " + formatToReal.format(price) + "\n" +
                "Número de paradas: " + numberOfStops;
    }
}
