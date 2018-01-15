package Data;

import Information.Serie;

import java.sql.*;
import java.util.ArrayList;


public class SerieRepository {
    private SqlConnection connection = null;

    public SerieRepository(SqlConnection sqlConnection) {
        this.connection = sqlConnection;
    }
    public ArrayList<Serie> getSeries(){
        ResultSet set = connection.executeSql("SELECT * FROM Serie");

        ArrayList<Serie> series = new ArrayList<>();
        try {
            while (set.next()) {
                series.add(new Serie(
                        set.getString("Serie"),
                        set.getString("Seizoen"),
                        set.getString("Leeftijd"),
                        set.getString("Taal"),
                        set.getString("Genre"),
                        set.getString("LijktEenBeetjeOp")));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return series;
    }
}



