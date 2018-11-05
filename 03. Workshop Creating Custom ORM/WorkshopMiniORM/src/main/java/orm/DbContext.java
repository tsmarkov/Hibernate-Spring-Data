package orm;

public interface DbContext<Е> {

    boolean persist(Е entity);

    Iterable<Е> find(Class<Е> table);

    Iterable<Е> find(Class<Е> table, String where);

    Е findFirst(Class<Е> table);

    Е findFirst(Class<Е> table, String where);
}
