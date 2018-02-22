import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Kysymykset {

    private int id;
    private String kysymys;
    private int vast_id;
    private int v_id;
    private String vastaus;

    public int getV_id() {
        return v_id;
    }

    public void setV_id(int v_id) {
        this.v_id = v_id;
    }

    public String getVastaus() {
        return vastaus;
    }

    public void setVastaus(String vastaus) {
        this.vastaus = vastaus;
    }

    public Kysymykset(int id, String kysymys, int vast_id) {
        this.id = id;
        this.kysymys = kysymys;
        this.vast_id = vast_id;
    }
    public Kysymykset(int id, String kysymys, int vast_id, int v_id) {
        this.id = id;
        this.kysymys = kysymys;
        this.vast_id = vast_id;
        this.v_id = v_id;
    }

    public Kysymykset(String kysymys, String vastaus) {
        this.kysymys = kysymys;
        this.vastaus = vastaus;
    }

    public void lisaaKysymysTauluun(Connection con) throws SQLException {
        String sql = "INSERT INTO Kysymykset(id, kysymys, vast_id) VALUES (?,?,?)";
        PreparedStatement kys = con.prepareStatement(sql);
        kys.setInt(1, this.id);
        kys.setString(2, this.kysymys);
        kys.setInt(3, vast_id);
        kys.execute();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKysymys() {
        return kysymys;
    }

    public void setKysymys(String kysymys) {
        this.kysymys = kysymys;
    }

    public int getVast_id() {
        return vast_id;
    }

    public void setVast_id(int vast_id) {
        this.vast_id = vast_id;
    }

    @Override
    public String toString() {
        return  kysymys;
    }
}
