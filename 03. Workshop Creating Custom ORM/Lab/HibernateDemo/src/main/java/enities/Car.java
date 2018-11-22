package enities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "koli")
public class Car {
    @Id
    private int id;

    @Column(name = "model")
    private String model;

    public Car() {
    }

    public Car(String model) {
        this.model = model;
    }

    public Car(int id, String model) {
        this.id = id;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
