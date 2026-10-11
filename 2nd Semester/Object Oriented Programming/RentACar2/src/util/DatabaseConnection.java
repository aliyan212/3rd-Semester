package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Update these with your actual MariaDB credentials
    private static final String URL = "jdbc:mariadb://localhost:3306/Rent_a_Car_2";
    private static final String USER = "db_student"; 
    private static final String PASSWORD = "secure_pass"; 

    // Singleton instance
    private static Connection connection = null;

    // Private constructor to prevent instantiation
    private DatabaseConnection() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Load the MariaDB driver
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Database connected successfully!");
            } catch (ClassNotFoundException e) {
                System.out.println("MariaDB JDBC Driver not found. Did you add the dependency?");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Failed to connect to the database.");
                e.printStackTrace();
            }
        }
        return connection;
    }
}
