import java.sql.*;
import java.util.*;

public class toiminnot {

    Connection con;

    public static void lataaAjuri() throws
            ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Ajuri ladattu");
    }

    public void yhteys() throws ClassNotFoundException {
        lataaAjuri();

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tentti?useSSL=false",
                             "root", "leenaschaumann");
            System.out.println("Connection created");


       /* Kysymykset eka = new Kysymykset(1,"Tietokanta (database/db) - palvelimella voi sijaita useita tietokantoja",1);
        Kysymykset toka = new Kysymykset(2,"MySql on avoimen lähdekoodin tietokanta", 1 );
        Kysymykset kolmas = new Kysymykset(3, "Sun omistaa MySql:n", 2);
        Kysymykset neljas = new Kysymykset(4, "mysqldump-toiminto tarkistaa taulujen eheyden", 2);
        Kysymykset viides = new Kysymykset(5, "SQL on deklaratiivinen kieli", 1);
        Kysymykset kuudes = new Kysymykset(6,"Alikysely on SELECT-lause, joka ympäröidään hakasulkeilla", 2 );
        Kysymykset seitsemas = new Kysymykset(7,"GRANT voi muokata olemassaolevan käyttäjän oikeuksia", 1 );
        Kysymykset kasi = new Kysymykset(8,"SHOW GRANTS FOR näyttää tietyn käyttäjän oikeudet", 1 );
        Kysymykset ysi = new Kysymykset(9, "Ajurit toimitetaan JAR-paketteina", 1 );
        Kysymykset kymppi = new Kysymykset(10, "DriverManager kuvaa yhteyttä tietokantapalvelimelle",2 );

        eka.lisaaKysymysTauluun(con);
        toka.lisaaKysymysTauluun(con);
        kolmas.lisaaKysymysTauluun(con);
        neljas.lisaaKysymysTauluun(con);
        viides.lisaaKysymysTauluun(con);
        kuudes.lisaaKysymysTauluun(con);
        seitsemas.lisaaKysymysTauluun(con);
        kasi.lisaaKysymysTauluun(con);
        ysi.lisaaKysymysTauluun(con);
        kymppi.lisaaKysymysTauluun(con);*/

           // System.out.println(kysymyksia(con));
        } catch (SQLException e) {
            e.printStackTrace();

        }


    }

    public static List<Kysymykset> kysymyksia(Connection con) throws SQLException {
        ArrayList<Kysymykset> kysymykset = new ArrayList<>();
        String sql = "select kysymys,vastaus from kysymykset join tf_vastaus on kysymykset.vast_id=tf_vastaus.v_id";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();


        while (rs.next()) {
            kysymykset.add(new Kysymykset(rs.getString("kysymys"),rs.getString("vastaus")));
        }
        return kysymykset;
    }

    public void kaynnistaKysely()  {
        try {
            yhteys();
            Scanner lukija = new Scanner(System.in);
            System.out.println("Tervetuloa tenttiin!");
            List<Kysymykset> kyssarit = new ArrayList<>(kysymyksia(con));
            Collections.shuffle(kyssarit);

            System.out.println("Tentissä kohtaat väitteitä viikon 5 aihealueista. \n" +
                    "Vastaa väitteisiin numeroin: 1 = totta tai 2 = valhe!");


                for (int i = 0; i < kyssarit.size(); i++) {
                    try {
                        System.out.println("Kysymys " + (i + 1) + ":");
                        System.out.println(kyssarit.get(i));
                        int vastaus = Integer.parseInt(lukija.nextLine());
                        if (vastaus != 1 && vastaus != 2) {
                            System.out.println("Tarkista ohjeet! Vastaa joko 1 tai 2.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Nyt kyllä meni persiilleen.");
                        continue;
                    }
                }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
    }

}



