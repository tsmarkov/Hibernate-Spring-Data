package entities;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private int age;
    private Date registrationDate;

    public User(String name, int age, Date registrationDate) {
        this.setName(name);
        this.setAge(age);
        this.setRegistrationDate(registrationDate);
    }

    public int getId() {
        return this.id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    private void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
