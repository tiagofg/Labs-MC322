package br.unicamp.ic.mc322.lab06.user;

public enum GenderEnum {

    MALE("Masculino"),
    FEMALE("Feminino"),
    NOT_INFORMED("Não informado");

    private String gender;

    GenderEnum(String gender) {
        this.gender = gender;
    }
}
