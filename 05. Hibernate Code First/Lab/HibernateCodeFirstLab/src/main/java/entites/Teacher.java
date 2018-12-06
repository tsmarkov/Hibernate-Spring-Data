package entites;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "teachers")
public class Teacher extends Person {
    private String speciality;
    private double salary;
    private boolean isKlasen;

    public Teacher() {
    }

    public Teacher(String name, int age, String speciality, double salary) {
        super(name, age);
        setSpeciality(speciality);
        setSalary(salary);
    }

    @Column
    public String getSpeciality() {
        return this.speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Column
    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Column
    public boolean isKlasen() {
        return isKlasen;
    }

    public void setKlasen(boolean klasen) {
        isKlasen = klasen;
    }
}
