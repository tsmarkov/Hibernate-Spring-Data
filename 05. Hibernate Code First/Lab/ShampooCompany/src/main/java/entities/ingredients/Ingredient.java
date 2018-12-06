package entities.ingredients;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import entities.shampoos.BasicShampoo;

public interface Ingredient extends Serializable {

    long getId();

    void setId(long id);

    String getName();

    void setName(String name);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    List<BasicShampoo> getShampoos();

    void setShampoos(List<BasicShampoo> shampoos);

}
