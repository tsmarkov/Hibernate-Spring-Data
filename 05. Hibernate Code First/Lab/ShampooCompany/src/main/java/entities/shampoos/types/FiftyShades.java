package entities.shampoos.types;

import entities.shampoos.BasicShampoo;
import entities.shampoos.Size;
import entities.shampoos.labels.BasicLabel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "FS")
public class FiftyShades extends BasicShampoo {

    //-------------------------------- FIELDS --------------------------------//

    private static final String BRAND = "Fifty shades";
    private static final BigDecimal PRICE = new BigDecimal("6.69");
    private static final Size SIZE = Size.SMALL;

    //----------------------------- CONSTRUCTORS -----------------------------//

    public FiftyShades() {
    }

    public FiftyShades(BasicLabel classicLabel) {
        super(BRAND, PRICE, SIZE, classicLabel);
    }
}
