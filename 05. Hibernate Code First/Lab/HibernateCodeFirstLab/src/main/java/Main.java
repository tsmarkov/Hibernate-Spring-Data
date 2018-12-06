import entites.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.sql.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test");
        EntityManager entityManager = factory.createEntityManager();

        // ---------------------------------------------------------------------------------------------------------- //
        entityManager.getTransaction().begin();

        Random random = new Random();
        // - Data insertion -
        Student student = new Student("Simon" + random.nextInt(100), random.nextInt(100), 8);
        entityManager.persist(student);

        Teacher teacher = new Teacher("Joan" + random.nextInt(100), random.nextInt(100), "Scala", 3200.30);
        entityManager.persist(teacher);

        Employee employee = new Employee("Peter" + random.nextInt(100), random.nextInt(100), new Date(1995, 12, 12));
        entityManager.persist(employee);

        Mother mother = new Mother("Gina" + random.nextInt(100), random.nextInt(100), employee);
        entityManager.persist(mother);

        entityManager.getTransaction().commit();

        // Get single object
        Mother mother1 = entityManager.find(Mother.class, 4);
        Person p = mother1.getChild();

        // printAllTeachers(entityManager);
        // printAllStudents(entityManager);
        printPersonIdAndName(entityManager, Teacher.class);
        printPersonIdAndName(entityManager, Student.class);

        entityManager.close();
        // ---------------------------------------------------------------------------------------------------------- //

        factory.close();
    }

    // Get data variant 1
    private static void printPersonIdAndName(EntityManager entityManager, Class tClass) {
        CriteriaQuery<Person> criteriaQuery = entityManager
                .getCriteriaBuilder()
                .createQuery(tClass);

        criteriaQuery.from(tClass);
        entityManager.createQuery(criteriaQuery)
                .getResultList().forEach(x -> System.out.println(x.getId() + " " + x.getName()));

    }

    // Get data variant 2
    private static void printAllTeachers(EntityManager entityManager) {
        AtomicInteger index = new AtomicInteger();
        Query query = entityManager.createQuery("FROM teachers", Teacher.class);
        query.getResultList().forEach((x) -> {
            if (index.get() == 0) {
                System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            }

            Teacher teacher1 = (Teacher) x;
            System.out.print(teacher1.getId() + "; ");
            System.out.print(teacher1.getName() + "; ");
            System.out.print(teacher1.getAge() + "; ");
            System.out.print(teacher1.getSpeciality() + "; ");
            System.out.println(teacher1.getSalary() + ";");
            index.getAndIncrement();
        });
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    private static void printAllStudents(EntityManager entityManager) {
        AtomicInteger index = new AtomicInteger();
        Query query = entityManager.createQuery("FROM students", Student.class);
        query.getResultList().forEach((x) -> {
            if (index.get() == 0) {
                System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            }

            Student teacher1 = (Student) x;
            System.out.print(teacher1.getId() + "; ");
            System.out.print(teacher1.getName() + "; ");
            System.out.print(teacher1.getAge() + "; ");
            System.out.println(teacher1.getGrade() + ";");
            index.getAndIncrement();
        });
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}