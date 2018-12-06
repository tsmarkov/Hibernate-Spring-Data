import entities.ingredients.BasicIngredient;
import entities.ingredients.basic.Mint;
import entities.ingredients.basic.Nettle;
import entities.ingredients.chemical.AmmoniumChloride;
import entities.shampoos.BasicShampoo;
import entities.shampoos.labels.BasicLabel;
import entities.shampoos.types.FreshNuke;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("shampoo_company");

        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        BasicIngredient am = new AmmoniumChloride();
        BasicIngredient mint = new Mint();
        BasicIngredient nettle = new Nettle();

        BasicLabel label =
                new BasicLabel("Fresh Nuke Shampoo", "Contains mint and nettle");

        BasicShampoo shampoo = new FreshNuke(label);

        shampoo.getIngredients().add(mint);
        shampoo.getIngredients().add(nettle);
        shampoo.getIngredients().add(am);
        entityManager.persist(shampoo);

        entityManager.getTransaction().commit();
        entityManager.close();
        managerFactory.close();
    }
}
