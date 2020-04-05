package lab03;

import java.text.NumberFormat;
import java.util.Locale;

public class User {

    private String name;
    private String cpf;
    private String birthDate;
    private String gender;
    private Float currentBalance;
    private boolean smoker;

    public User(String name, String cpf, String birthDate, String gender, Float currentBalance, boolean smoker) {
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.gender = gender;
        this.currentBalance = currentBalance;
        this.smoker = smoker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Float getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Float currentBalance) {
        this.currentBalance = currentBalance;
    }

    public boolean isSmoker() {
        return smoker;
    }

    public void setSmoker(boolean smoker) {
        this.smoker = smoker;
    }

    public void printUserData() {
        NumberFormat formatToReal = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        System.out.println("------------Dados do usuário------------");
        System.out.println("Nome: " + name);
        System.out.println("CPF: " + cpf);
        System.out.println("Data de nascimento: " + birthDate);
        System.out.println("Gênero: " + gender);
        System.out.println("Saldo: " + formatToReal.format(currentBalance));
        System.out.println("Fumante: " + (smoker ? "Sim" : "Não"));
    }
}
