package entites;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "departments")
public class Department {
    private int id;
    private String name;
//    private Set<Employee> employees;

    public Department() {
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @OneToMany
//    @JoinTable(
//            @JoinColumn(name = "deparment_id")
//    )
//    public Set<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(List<Employee> employees) {
//        this.employees = employees;
//    }
}
