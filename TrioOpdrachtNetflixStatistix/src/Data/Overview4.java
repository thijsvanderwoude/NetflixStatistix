package Data;

import Information.Movie;

import java.sql.*;
import java.util.ArrayList;

public class Overview4 {

    private SqlConnection connection = null;

    public Overview4(SqlConnection sqlConnection){
        this.connection = sqlConnection;

    }

    public ArrayList<Movie> getMovies() {
        ResultSet set = connection.executeSql("SELECT Id, Titel, Leeftijdsindicatie, Taal, Tijdsduur, Genre FROM Film WHERE Leeftijdsindicatie != '18 jaar en ouder' AND Leeftijdsindicatie != '16 jaar en ouder' AND Tijdsduur IN (SELECT MAX(Tijdsduur) FROM Film)");

      ArrayList <Movie> movies = new ArrayList<>();
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
      } catch (Exception e) {
              System.out.println(e);
          }
        return movies;
    }
}
