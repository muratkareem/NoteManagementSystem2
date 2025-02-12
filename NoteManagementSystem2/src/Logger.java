import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class Logger {
    private Connection connection;

    public Logger() {
        connection = DatabaseConnection.getInstance().getConnection();
    }

    public boolean LogAuth(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            // Set the email parameter in the query
            statement.setString(1, username);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            if (password.equals(resultSet.getString("password"))) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return false;
    }

    public int getId(String username) {
        String query = "SELECT id FROM users WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            // Set the email parameter in the query
            statement.setString(1, username);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("id");
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return 0;
    }
}
