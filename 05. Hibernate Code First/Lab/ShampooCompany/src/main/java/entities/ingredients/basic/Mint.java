package entities.ingredients.basic;

import entities.ingredients.BasicIngredient;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "MN")
public class Mint extends BasicIngredient {

    //-------------------------------- FIELDS --------------------------------//

    private static final String NAME = "Mint";
    private static final BigDecimal PRICE = new BigDecimal("3.54");

    //----------------------------- CONSTRUCTORS -----------------------------//

    public Mint() {
        super(NAME, PRICE);
    }
}
