import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Kysymykset {

    private int id;
    private String kysymys;
    private int vast_id;

    public Kysymykset(int id, String kysymy, int vast_id) {
        this.id = id;
        this.kysymys = kysymys;
        this.vast_id = vast_id;

    }

    public void lisaaKysymysTauluun(Connection con) throws SQLException {
        String sql = "INSERT INTO Kysymykset(id, kysymys, vastaus_id) VALUES (?,?,?)";
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
        return "Kysymykset{" +
                "id=" + id +
                ", kysymys='" + kysymys + '\'' +
                ", vast_id=" + vast_id +
                '}';
    }
}
