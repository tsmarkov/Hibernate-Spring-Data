package orm;

import java.sql.SQLException;

public interface DbContext<T> {

    boolean persist(T entity);

    Iterable<T> find(Class<T> table) throws SQLException;

    Iterable<T> find(Class<T> table, String where);

    T findFirst(Class<T> table);

    T findFirst(Class<T> table, String where);
}
