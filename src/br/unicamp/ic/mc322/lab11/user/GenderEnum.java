package br.unicamp.ic.mc322.lab11.user;

public enum GenderEnum {

    MALE("Masculino"),
    FEMALE("Feminino"),
    NOT_INFORMED("Não informado");

    private String gender;

    GenderEnum(String gender) {
        this.gender = gender;
    }

    public static GenderEnum getGender(String gender) {
        for (GenderEnum genderEnum : GenderEnum.values()) {
            if (genderEnum.gender.equals(gender)) {
                return genderEnum;
            }
        }

        return NOT_INFORMED;
    }
}
