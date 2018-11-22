package entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher extends Person{

    @Column(nullable = false)
    private String speciality;

    public Teacher() {
    }

    public Teacher(int id, String name, String speciality) {
        super(id, name);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
