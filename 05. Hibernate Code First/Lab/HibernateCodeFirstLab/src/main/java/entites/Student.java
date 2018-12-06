package entites;

import javax.persistence.*;

@Entity(name = "students")
public class Student extends Person {
    private int grade;

    public Student() {
    }

    public Student(String name, int age, int grade) {
        super(name, age);
        setGrade(grade);
    }

    @Column
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
