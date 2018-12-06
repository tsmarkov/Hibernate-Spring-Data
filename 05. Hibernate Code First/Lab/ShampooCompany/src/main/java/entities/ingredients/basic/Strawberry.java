package entities.ingredients.basic;

import entities.ingredients.BasicIngredient;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "ST")
public class Strawberry extends BasicIngredient {

    //----------------------------- CONSTRUCTORS -----------------------------//

    private static final String NAME = "Strawberry";
    private static final BigDecimal PRICE = new BigDecimal("4.85");

    //-------------------------------- FIELDS --------------------------------//

    public Strawberry() {
        super(NAME, PRICE);
    }
}
