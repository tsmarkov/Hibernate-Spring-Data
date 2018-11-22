package entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends Person {

    @Column(nullable = false)
    private int grade;

    public Student() {
    }

    public Student(int id, String name, int grade) {
        super(id, name);
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
