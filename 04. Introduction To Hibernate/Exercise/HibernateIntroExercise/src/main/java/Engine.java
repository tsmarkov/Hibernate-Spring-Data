import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Engine implements Runnable {
    private final EntityManager entityManager;
    private BufferedReader reader;

    Engine(EntityManager entityManager) {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.entityManager = entityManager;
    }

    /**
     * 2. Remove objects
     */
    private void removeObjectsFromTowns() {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("FROM Town", Town.class);

        List<Town> towns = query.getResultList();
        towns.forEach(town -> {
            if (town.getName().length() > 5) {
                entityManager.detach(town);
            } else {
                String newTownName = town.getName().toLowerCase();
                town.setName(newTownName);
                entityManager.persist(town);
            }
        });

        entityManager.getTransaction().commit();
    }

    /**
     * 3. Contains employee
     */
    private void containsEmployee() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        entityManager.getTransaction().begin();

        try {
            Employee employee = entityManager
                    .createQuery(
                            "FROM Employee " +
                                    "WHERE concat(first_name, ' ', last_name) = :name",
                            Employee.class
                    )
                    .setParameter("name", name)
                    .getSingleResult();

            System.out.println("Yes");
        } catch (NoResultException e) {
            System.out.println("No");
        }

        entityManager.getTransaction().commit();
    }

    /**
     * 4. Employees with Salary Over 50 000
     */
    private void employeesWithSalaryOver50000() {
        entityManager.getTransaction().begin();

        List<String> namesOfEmployees = entityManager
                .createQuery(
                        "SELECT firstName " +
                                "FROM Employee " +
                                "WHERE salary > 50000",
                        String.class
                )
                .getResultList();

        namesOfEmployees.forEach(System.out::println);

        entityManager.getTransaction().commit();
    }

    /**
     * 5.Employees from Department
     */
    private void employeesFromDepartment() {
        String departmentName = "Research and Development";

        entityManager.getTransaction().begin();

        List<Object[]> employeesNames = entityManager.createQuery(
                "SELECT  e.firstName, e.lastName, dep.name, e.salary " +
                        "FROM Employee e " +
                        "JOIN e.department dep on e.department.id = dep.id " +
                        "WHERE dep.name = :department " +
                        "ORDER BY e.salary ASC, e.id ASC",
                Object[].class
        ).setParameter("department", departmentName)
                .getResultList();

        employeesNames.forEach(x -> {
            System.out.println(x[0] + " " + x[1] + " from " + x[2] + " - $" + x[3]);
        });

        entityManager.getTransaction().commit();
    }

    /**
     * 6.Adding a New Address and Updating Employee
     */
    private void addNewAddressAndUpdateEmployee() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        entityManager.getTransaction().begin();

        Town town = entityManager
                .createQuery(
                        "FROM Town t WHERE t.name = 'Sofia'",
                        Town.class
                ).getSingleResult();

        Address newAddress = new Address();
        newAddress.setText("Vitoshka 15");
        newAddress.setTown(town);
        entityManager.persist(newAddress);

        Employee employee = entityManager
                .createQuery(
                        "FROM Employee e WHERE e.lastName = :name",
                        Employee.class
                ).setParameter("name", name)
                .getSingleResult();

        entityManager.detach(employee.getAddress());
        employee.setAddress(newAddress);
        entityManager.merge(employee);

        entityManager.getTransaction().commit();
    }

    /**
     * 7.Addresses with Employee Count
     */
    private void addressesWithEmployeeCount() {
        List<Object[]> res = entityManager
                .createQuery(
                        "SELECT a.text, t.name, a.employees.size FROM Address a " +
                                "JOIN Town t ON a.town.id = t.id " +
                                "ORDER BY a.employees.size DESC, a.town.id ASC",
                        Object[].class
                ).setMaxResults(10)
                .getResultList();

        for (Object[] re : res) {
            System.out.println(re[0] + " " + re[1] + " " + re[2]);
        }
    }


    /**
     * 8.Get Employee with Project
     */
    private void getEmployeeWithProject() {
        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.nextLine());

        var e = entityManager
                .createQuery(
                        "FROM Employee e JOIN Project p WHERE e.id = :id"
                )
                .setParameter("id", id)
                .getResultList();

        System.out.println(e);
    }

    // TODO: Write the rest of the exercises

    @Override
    public void run() {
        // 2
        //this.removeObjectsFromTowns();

        // 3
        //this.containsEmployee();

        // 4
        //this.employeesWithSalaryOver50000();

        // 5
        //this.employeesFromDepartment();

        // 6
        //this.addNewAddressAndUpdateEmployee();

        // 7
        //this.addressesWithEmployeeCount();

        // 8
        this.getEmployeeWithProject();
    }
}
