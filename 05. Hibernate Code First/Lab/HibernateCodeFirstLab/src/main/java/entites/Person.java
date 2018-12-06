package entites;

import javax.persistence.*;

//@MappedSuperclass
@Entity(name = "people")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Person {
    private int id;
    private String name;
    private int age;
    private Person mother;

    public Person() {
    }

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(length = 100, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @OneToOne(mappedBy = "child", targetEntity = Mother.class)
    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }
}
