import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

import entities.User;
import orm.Connector;
import orm.DbContext;
import orm.EntityManager;

public class Main {
    private static final String DEFAULT_USERNAME = "root";
    private static final String DEFAULT_DB_NAME = "simple_orm";

    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter username (default: \"root\"): ");
        String username = reader.readLine();
        username = username.isEmpty() ? DEFAULT_USERNAME : username;

        System.out.print("Enter password (default: empty string): ");
        String password = reader.readLine();

        System.out.print("Enter database name (default: \"simple_orm\"): ");
        String databaseName = reader.readLine();
        databaseName = databaseName.isEmpty() ? DEFAULT_DB_NAME : databaseName;

        Connector.createConnection(username, password, databaseName);
        Connection connection = Connector.getConnection();

        /*PreparedStatement query = connection.prepareStatement(
                "SELECT * " +
                        "FROM employees AS e " +
                        "WHERE e.employee_id BETWEEN 1 AND 20"
        );

        ResultSet resultSet = query.executeQuery();

        while (resultSet.next()) {
            System.out.println(
                    resultSet.getString("employee_id") + "  -  " +
                            resultSet.getString("first_name") + "  -  " +
                            resultSet.getString("last_name")
            );
        }*/

        DbContext<User> usersDbContext =
                new EntityManager<>(connection, User.class);

        var let = usersDbContext.find(User.class);
        let.forEach(System.out::println);
    }
}
