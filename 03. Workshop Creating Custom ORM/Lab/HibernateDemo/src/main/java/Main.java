import enities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("cars");

//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//
//        Employee employee = new Employee("Gesho", "Neshov", 81);
//        Employee employee2 = new Employee("Jaklin", "Jabata", 38);
//        Employee employee3 = new Employee("Alfred", "Kauna", 62);
//        entityManager.persist(employee);
//        entityManager.persist(employee2);
//        entityManager.persist(employee3);
//
//        employee.setAge(11);
//
//        entityManager.getTransaction().commit();
//        entityManager.close();
//
//        employee2.setAge(99);
    }
}
