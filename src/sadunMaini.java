import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class sadunMaini {

    public static void main(String[] args) {

        Kysymykset eka = new Kysymykset(1,"Tietokanta (database/db) - palvelimella voi sijaita useita tietokantoja",1);
        Kysymykset toka = new Kysymykset(2,"MySql on avoimen lähdekoodin tietokanta", 1 );

    }
    public static List<Kysymykset> kysymyksia(Connection con) throws SQLException {
        ArrayList<Kysymykset> kysymykset = new ArrayList<>();



        return kysymykset;
    }


}
