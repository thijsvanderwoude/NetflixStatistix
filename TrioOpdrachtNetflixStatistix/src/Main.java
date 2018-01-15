/**
 * Dit is een voorbeeld Java toepassing waarin je verbinding maakt met een SQLServer database.
 */
import Data.Overview4;
import Data.SqlConnection;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SqlConnection connection = new SqlConnection();
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=NetflixStatistix;integratedSecurity=true;";
        connection.connectDatabase(url);

        Overview4 repo = new Overview4(connection);
        System.out.println(repo.getMovies());

        JFrame frame = new JFrame("Netflix Statistix");
        frame.setContentPane(new GUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}