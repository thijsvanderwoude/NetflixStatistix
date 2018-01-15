import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import Data.*;
import Information.Aflevering;
import Information.Movie;
import Information.Profile;
import Information.Serie;
import TableModel.*;

public class GUI {
    private JButton Btn_Msg;
    protected JPanel panel1;
    private JTable table1;
    private JButton Btn_view1;
    private JButton Btn_view2;
    private JButton Btn_view3;
    private JButton Btn_view4;
    private JButton Btn_view5;
    private JButton Btn_view6;
    private JPanel Panel_Overzicht;
    private JButton Btn_test;
    private JPanel Panel_Test;
    private JPanel Panel_View1;
    private JPanel Panel_Content;
    private JPanel Panel_View2;
    private JPanel Panel_View3;
    private JPanel Panel_View4;
    private JPanel Panel_View5;
    private JPanel Panel_View6;
    private JButton Btn_View4Calculate;
    private JLabel Lbl_MoviePlaceholder;
    private JTable table3;
    private JButton button2;
    private JTable table4;
    private JButton button3;
    private JTable table5;
    private JList list1;
    private JButton button4;
    private JTable table6;
    private JList list2;
    private JButton button5;
    private JTable table2;

    //Call this function to empty the content panel. After you called this you can add new content to the content panel (view 1 - 6).
    public void RemovePanelContent(){
        Panel_Content.removeAll();
        Panel_Content.repaint();
        Panel_Content.revalidate();
    }


    //Test button on test view to retrieve all movies from database and show in table.
    public GUI() {



        //The seven buttons on the left side that switch panels actions:
        Btn_view1.addActionListener(e -> {
            RemovePanelContent();
            Panel_Content.add(Panel_View1);
        });
        Btn_view2.addActionListener(e -> {
            RemovePanelContent();
            Panel_Content.add(Panel_View2);
        });
        Btn_view3.addActionListener(e -> {
            RemovePanelContent();
            Panel_Content.add(Panel_View3);
        });
        Btn_view4.addActionListener(e -> {
            RemovePanelContent();
            Panel_Content.add(Panel_View4);
        });
        Btn_view5.addActionListener(e -> {
            RemovePanelContent();
            Panel_Content.add(Panel_View5);
        });
        Btn_view6.addActionListener(e -> {
            RemovePanelContent();
            Panel_Content.add(Panel_View6);
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Movie> movies = null;
                SqlConnection connection = new SqlConnection();
                String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=NetflixStatistix;integratedSecurity=true;";
                connection.connectDatabase(connectionUrl);
                Overview4 repo = new Overview4(connection);
                movies = repo.getMovies();
                MovieTableModel model = new MovieTableModel(movies);
                System.out.println(model);
                table3.setModel(model);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Movie> movies = null;
                SqlConnection connection = new SqlConnection();
                String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=NetflixStatistix;integratedSecurity=true;";
                connection.connectDatabase(connectionUrl);
                Overview4 repo = new Overview4(connection);
                movies = repo.getMovies();
                MovieTableModel model = new MovieTableModel(movies);
                System.out.println(model);
                table4.setModel(model);
            }
        });

        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                SqlConnection connection = new SqlConnection();
                String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=NetflixStatistix;integratedSecurity=true;";
                connection.connectDatabase(connectionUrl);
                ResultSet set = connection.executeSql("SELECT * FROM Film WHERE Id IN (SELECT Gezien FROM Bekeken WHERE Abonneenummer = 5602533 AND Profielnaam = '"+list1.getSelectedValue().toString() + "')");
                ArrayList<Movie> movies = new ArrayList<>();
                try {
                    while(set.next()) {
                        movies.add(new Movie(
                                set.getInt("Id"),
                                set.getString("Titel"),
                                set.getString("Leeftijdsindicatie"),
                                set.getString("Taal"),
                                set.getString("Tijdsduur"),
                                set.getString("Genre")));
                    }
                } catch (Exception x) {
                    System.out.println(x);
                }
                MovieTableModel model = new MovieTableModel(movies);
                System.out.println(model);
                table5.setModel(model);
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel<String> model = new DefaultListModel<>();
                List<Profile> profiles1 = null;
                SqlConnection connection = new SqlConnection();
                String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=NetflixStatistix;integratedSecurity=true;";
                connection.connectDatabase(connectionUrl);
                SelectProfile profile = new SelectProfile(connection);
                profiles1 = profile.getProfile();
                for (int i = 0; i < profiles1.size(); i++) {
                    Profile profieltje = profiles1.get(i);
                    model.addElement(profieltje.getName());
                }
                list1.setModel(model);
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel<String> model = new DefaultListModel<>();
                List<Serie> Serie = null;
                SqlConnection connection = new SqlConnection();
                String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=NetflixStatistix;integratedSecurity=true;";
                connection.connectDatabase(connectionUrl);
                SerieRepository seriexd = new SerieRepository(connection);
                Serie = seriexd.getSeries();
                for (int i = 0; i < Serie.size(); i++) {
                    Serie serie = Serie.get(i);
                    model.addElement(serie.getSerie());
                }
                list2.setModel(model);
            }
        });
        list2.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                SqlConnection connection = new SqlConnection();
                String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=NetflixStatistix;integratedSecurity=true;";
                connection.connectDatabase(connectionUrl);
                ResultSet set = connection.executeSql("SELECT Aflevering.Id, Aflevering.Titel, AVG(Bekeken.Percentage) as Average FROM Aflevering JOIN Bekeken ON Aflevering.Id = Bekeken.Gezien WHERE Aflevering.Serie = '"+list2.getSelectedValue().toString() + "' GROUP BY Aflevering.Id, Aflevering.Titel");
                ArrayList<Aflevering> afleverings = new ArrayList<>();
                try {
                    while (set.next()) {
                        afleverings.add(new Aflevering(
                                set.getInt("Id"),
                                set.getInt("Serie"),
                                set.getString("Seizoen"),
                                set.getString("Titel"),
                                set.getString("Average")));

                    }
                } catch (Exception y) {
                    System.out.println(y);
                }
                EpisodeTableModel model = new EpisodeTableModel(afleverings);
                System.out.println(model);
                table5.setModel(model);
            }
        });
        Btn_view5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Profile> profile = null;
                SqlConnection connection = new SqlConnection();
                String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=NetflixStatistix;integratedSecurity=true;";
                connection.connectDatabase(connectionUrl);
                ProfileRepository repo = new ProfileRepository(connection);
                profile = repo.getProfile();
                ProfileTableModel model = new ProfileTableModel(profile);
                System.out.println(model);
                table2.setModel(model);
            }
        });
    }
}
