package br.unicamp.ic.mc322.lab10.users;

import java.time.LocalDate;

public abstract class User {

    private String name;
    private String cpf;
    private LocalDate birthDate;

    public User(String name, String cpf, LocalDate birthDate) {
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Nome: " + name +
                ", CPF: " + cpf +
                ", data de nascimento: " + birthDate;
    }
}
