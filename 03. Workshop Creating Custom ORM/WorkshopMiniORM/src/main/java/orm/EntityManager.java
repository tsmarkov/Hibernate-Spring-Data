package orm;

import anotations.Entity;
import entities.User;

import java.lang.annotation.Annotation;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class EntityManager<T> implements DbContext<T> {
    private static final String SELECT_QUERY_TEMPLATE = "SELECT * FROM %s";
    private Connection connection;
    private Class<T> clazz;

    public EntityManager(Connection connection, Class<T> className) {
        this.connection = connection;
        this.clazz = className;
    }

    public boolean persist(T entity) {
        return false;
    }

    public Iterable<T> find(Class<T> table) throws SQLException {
        String queryString = String.format(
                SELECT_QUERY_TEMPLATE,
                this.getTableName()
        );

        PreparedStatement query = connection.prepareStatement(queryString);
        ResultSet resultSet = query.executeQuery();

        ArrayList<T> list = new ArrayList<>();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            Date registrationDate = resultSet.getDate("registration_date");

            User user = new User(name, age, Calendar.getInstance().getTime());
            list.add((T) user);
        }

        return list;
    }

    public Iterable<T> find(Class<T> table, String where) {
        return null;
    }

    public T findFirst(Class<T> table) {
        return null;
    }

    public T findFirst(Class<T> table, String where) {
        return null;
    }

    private String getTableName() {
        Annotation annotation = Arrays.stream(clazz.getAnnotations())
                .filter(a -> a.annotationType() == Entity.class)
                .findFirst()
                .orElse(null);

        if (annotation == null) {
            return clazz.getSimpleName().toLowerCase() + "s";
        }

        return clazz.getAnnotation(Entity.class).name();
    }
}
