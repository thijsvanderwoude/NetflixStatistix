
import Repositories.SqlConnection;
import GUI.UserInterface;
import javax.swing.SwingUtilities;
import java.sql.*;

public class Main {

    public static void main(String[] args) {

        String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=NetflixStatistix;integratedSecurity=true;";
        connection.connectDatabase(connectionUrl);
        UserInterface ui = new UserInterface();
        SwingUtilities.invokeLater(ui);

    }
}
