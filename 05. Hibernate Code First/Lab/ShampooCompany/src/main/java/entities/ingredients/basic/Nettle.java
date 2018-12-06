package entities.ingredients.basic;

import entities.ingredients.BasicIngredient;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "NT")
public class Nettle extends BasicIngredient {

    //-------------------------------- FIELDS --------------------------------//

    private static final String NAME = "Nettle";
    private static final BigDecimal PRICE = new BigDecimal("6.12");

    //----------------------------- CONSTRUCTORS -----------------------------//

    public Nettle() {
        super(NAME, PRICE);
    }
}
