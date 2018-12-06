package entities.shampoos.types;

import entities.shampoos.BasicShampoo;
import entities.shampoos.Size;
import entities.shampoos.labels.BasicLabel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "FN")
public class FreshNuke extends BasicShampoo {

    //-------------------------------- FIELDS --------------------------------//

    private static final String BRAND = "Fresh nuke";
    private static final BigDecimal PRICE = new BigDecimal("9.33");
    private static final Size SIZE = Size.BIG;

    //----------------------------- CONSTRUCTORS -----------------------------//

    public FreshNuke() {
    }

    public FreshNuke(BasicLabel classicLabel) {
        super(BRAND, PRICE, SIZE, classicLabel);
    }
}
