package entities.ingredients;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public abstract class BasicChemicalIngredient extends BasicIngredient implements ChemicalIngredient {

    //-------------------------------- FIELDS --------------------------------//

    @Column(name = "chemical_formula")
    private String chemicalFormula;

    //----------------------------- CONSTRUCTORS -----------------------------//

    public BasicChemicalIngredient() {
    }

    public BasicChemicalIngredient(String name, BigDecimal price) {
        super(name, price);
    }

    public BasicChemicalIngredient(String name, BigDecimal price, String chemicalFormula) {
        super(name, price);
        this.chemicalFormula = chemicalFormula;
    }

    //--------------------------- GETTERS & SETTERS --------------------------//

    @Override
    public String getChemicalFormula() {
        return this.chemicalFormula;
    }

    @Override
    public void setChemicalFormula(String chemicalFormula) {
        this.chemicalFormula = chemicalFormula;
    }
}
