package br.unicamp.ic.mc322.lab10.users;

import java.time.LocalDate;

public class Passenger extends User {

    private String creditCard;

    public Passenger(String name, String cpf, LocalDate birthDate, String creditCard) {
        super(name, cpf, birthDate);
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", cartão de crédito: " + creditCard;
    }
}
