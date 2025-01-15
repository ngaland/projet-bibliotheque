import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


        private static final String URL = "jdbc:postgresql://localhost:5432/bibliotheque";
        private static final String USER = "admin";
        private static final String PASSWORD = "admin123";

        public static Connection getConnection() throws SQLException {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("PostgreSQL JDBC Driver not found.");
                e.printStackTrace();
            }
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }

}
