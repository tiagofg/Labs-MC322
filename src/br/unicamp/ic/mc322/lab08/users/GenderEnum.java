package br.unicamp.ic.mc322.lab08.users;

public enum GenderEnum {

    MALE("Masculino"),
    FEMALE("Feminino"),
    NOT_INFORMED("Não informado");

    private final String gender;

    GenderEnum(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
