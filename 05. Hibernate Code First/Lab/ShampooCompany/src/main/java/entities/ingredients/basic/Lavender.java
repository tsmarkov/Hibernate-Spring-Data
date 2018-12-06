package entities.ingredients.basic;

import entities.ingredients.BasicIngredient;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "LV")
public class Lavender extends BasicIngredient {

    //-------------------------------- FIELDS --------------------------------//

    private static final String NAME = "Lavender";
    private static final BigDecimal PRICE = new BigDecimal("2.0");

    //----------------------------- CONSTRUCTORS -----------------------------//

    public Lavender() {
        super(NAME, PRICE);
    }
}
