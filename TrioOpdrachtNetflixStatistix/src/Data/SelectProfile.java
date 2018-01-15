package Data;


import Information.Profile;

import java.sql.*;
import java.util.ArrayList;

public class SelectProfile{
    private SqlConnection connection = null;

    public SelectProfile(SqlConnection sqlConnection) {
        this.connection = sqlConnection;
    }
    public ArrayList<Profile> getProfile(){
        ResultSet set = connection.executeSql("SELECT Abonneenummer, Profielnaam, Geboortedatum FROM Profiel GROUP BY Abonneenummer, Profielnaam, Geboortedatum");

        ArrayList<Profile> profile = new ArrayList<>();
        try {
            while (set.next()) {
                profile.add(new Profile(
                        set.getInt("Abonneenummer"),
                        set.getString("Profielnaam"),
                        set.getString("Geboortedatum")));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return profile;
    }
}

