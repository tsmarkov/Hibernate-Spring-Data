package entites;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "employees")
public class Employee extends Person {
    private Date hireDate;
    private Department department;

    public Employee() {
    }

    public Employee(String name, int age, Date hireDate) {
        super(name, age);
        this.hireDate = hireDate;
    }

    public Employee(String name, int age, Date hireDate, Department department) {
        super(name, age);
        this.hireDate = hireDate;
        this.department = department;
    }

    @Column(name = "hire_date")
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
