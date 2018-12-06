package entities.shampoos.types;

import entities.shampoos.BasicShampoo;
import entities.shampoos.Size;
import entities.shampoos.labels.BasicLabel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "PP")
public class PinkPanther extends BasicShampoo {

    //-------------------------------- FIELDS --------------------------------//

    private static final String BRAND = "Fresh nuke";
    private static final BigDecimal PRICE = new BigDecimal("8.50");
    private static final Size SIZE = Size.MEDIUM;

    //----------------------------- CONSTRUCTORS -----------------------------//

    public PinkPanther() {
    }

    public PinkPanther(BasicLabel classicLabel) {
        super(BRAND, PRICE, SIZE, classicLabel);
    }
}
