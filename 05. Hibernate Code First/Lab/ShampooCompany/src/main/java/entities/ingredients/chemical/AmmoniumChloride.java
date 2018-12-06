package entities.ingredients.chemical;

import entities.ingredients.BasicChemicalIngredient;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "AM")
public class AmmoniumChloride extends BasicChemicalIngredient {

    //-------------------------------- FIELDS --------------------------------//

    private static final String NAME = "Ammonium chloride";
    private static final BigDecimal PRICE = new BigDecimal("6.12");
    private static final String CHEMICAL_FORMULA = "NH4Cl";

    //----------------------------- CONSTRUCTORS -----------------------------//

    public AmmoniumChloride() {
        super(NAME, PRICE, CHEMICAL_FORMULA);
    }

}
