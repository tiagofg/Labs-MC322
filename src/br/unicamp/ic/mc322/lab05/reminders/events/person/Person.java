package br.unicamp.ic.mc322.lab05.reminders.events.person;

public class Person {

    private String name;
    private String email;
    private String phone;

    public Person(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        Person person = ((Person) obj);

        return this.getName().equals(person.getName()) &&
               this.getEmail().equals(person.getEmail()) &&
               this.getPhone().equals(person.getPhone());
    }
}
