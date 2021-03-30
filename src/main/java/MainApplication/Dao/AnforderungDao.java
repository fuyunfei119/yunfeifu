package MainApplication.Dao;

import MainApplication.Bean.Abteilung;
import MainApplication.Bean.Anforderung;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class AnforderungDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<Anforderung> showallinfo(){
        String sql = "select * from anforderung";
        List<Anforderung> anforderungs = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Anforderung>(Anforderung.class));
        return anforderungs;
    }

    public int anforderungadd(Anforderung anforderung){
        String sql = "insert into anforderung (Anforderung_id,Anforderung_name,Anforderung_beschreibung,zu_gewinnen_Umsatz,Eintragungszeit,Auftraggeber,Abteilung_id,Arbeitnehmer) values(?,?,?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, null, anforderung.getAnforderung_name(), anforderung.getAnforderung_beschreibung(),anforderung.getZu_gewinnen_Umsatz(),
                new Timestamp(System.currentTimeMillis()),anforderung.getAuftraggeber(),anforderung.getAbteilung_id(),anforderung.getArbeitnehmer());
        return update;
    }

    public int anforderungdelete(Integer id){
        String sql = "delete from anforderung where Anforderung_id = ?";
        int update = jdbcTemplate.update(sql, id);
        return update;
    }


    public Anforderung nativeinfo(Integer id){
        String sql = "select * from anforderung where Anforderung_id = ?";
        Anforderung anforderung = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Anforderung>(Anforderung.class), id);
        return anforderung;
    }

    public int runedit(Anforderung anforderung,Integer id){
        String sql = "update anforderung set Anforderung_name = ?,Anforderung_beschreibung = ?,zu_gewinnen_Umsatz = ?,Auftraggeber = ?,Abteilung_id = ?,Arbeitnehmer = ? where Anforderung_id = ?";
        int update = jdbcTemplate.update(sql, anforderung.getAnforderung_name(), anforderung.getAnforderung_beschreibung(),anforderung.getZu_gewinnen_Umsatz(),anforderung.getAuftraggeber(),
                anforderung.getAbteilung_id(),anforderung.getArbeitnehmer(),id);
        return update;
    }

    public Anforderung anforderungview(Integer id){
        String sql = "select kunden.kundennummer,kunden.kundenname,arbeitnehmer.name,anforderung.*,abteilung.Abteilung_name from anforderung,abteilung,arbeitnehmer,kunden where anforderung.Auftraggeber = abteilung.Abteilung_id and anforderung.Anforderung_id = ? and anforderung.Arbeitnehmer = arbeitnehmer.id and kunden.kundennummer = anforderung.Auftraggeber;\n";
        Anforderung anforderung = jdbcTemplate.queryForObject(sql, new RowMapper<Anforderung>() {
            @Override
            public Anforderung mapRow(ResultSet resultSet, int i) throws SQLException {
                Anforderung anforderung = new Anforderung();
                Abteilung abteilung = new Abteilung();
                anforderung.setAnforderung_id(resultSet.findColumn("Anforderung_id"));
                anforderung.setAnforderung_name(resultSet.getString("Anforderung_name"));
                anforderung.setAnforderung_beschreibung(resultSet.getString("Anforderung_beschreibung"));
                anforderung.setZu_gewinnen_Umsatz(resultSet.getDouble("zu_gewinnen_Umsatz"));
                anforderung.setEintragungszeit(resultSet.getDate("Eintragungszeit"));
                anforderung.setAuftraggeber(resultSet.getInt("Auftraggeber"));
                abteilung.setAbteilung_name(resultSet.getString("Abteilung_name"));
                anforderung.setAbteilung_id(resultSet.getInt("Abteilung_id"));
                anforderung.setArbeitnehmer(resultSet.getInt("Arbeitnehmer"));
                anforderung.setAnforderung_name(resultSet.getString("name"));
                anforderung.setKundenname(resultSet.getString("kundenname"));
                anforderung.setKundennummer(resultSet.getInt("kundennummer"));
                anforderung.setAbteilung(abteilung);
                return anforderung;
            }
        },id);
        return anforderung;
    }

    public Integer sum(){
        String sql = "select count(anforderung.Anforderung_id) from anforderung;";
        return jdbcTemplate.queryForObject(sql,int.class);
    }

}
