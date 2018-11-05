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
    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter username: ");
        String username = reader.readLine();

        System.out.print("Enter password: ");
        String password = reader.readLine();

        System.out.print("Enter database name: ");
        String databaseName = reader.readLine();

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

        DbContext<User> usersDbContext = new EntityManager<>(connection);
    }
}
