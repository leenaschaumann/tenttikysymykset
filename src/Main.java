import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection con =
                     (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tentti?useSSL=false",
                             "root", "leenaschaumann")) {
            System.out.println("Connection created");

            System.out.println("MOi");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
