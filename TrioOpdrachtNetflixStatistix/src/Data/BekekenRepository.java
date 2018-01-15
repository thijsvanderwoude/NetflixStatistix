package Data;


    import Information.Bekeken;

import java.sql.*;
import java.util.ArrayList;

    public class BekekenRepository{
        private SqlConnection connection = null;

        public BekekenRepository(SqlConnection sqlConnection) {
            this.connection = sqlConnection;
        }
        public ArrayList<Bekeken> getBekeken(){
            ResultSet set = connection.executeSql("SELECT * FROM Film WHERE Id IN (SELECT Gezien FROM Bekeken WHERE Abonneenummer = 5602533 AND Profielnaam = 'Petrus')");

            ArrayList<Bekeken> bekekens = new ArrayList<>();
            try {
                while (set.next()) {
                    bekekens.add(new Bekeken(
                            set.getInt("Id"),
                            set.getString("Titel"),
                            set.getInt("Gezien"),
                            set.getInt("Percentage")));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            return bekekens;
        }
    }

