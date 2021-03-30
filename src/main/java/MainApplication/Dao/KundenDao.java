package MainApplication.Dao;

import MainApplication.Bean.Anforderung;
import MainApplication.Bean.Kunden;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class KundenDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public int DeleteKunden(Integer id){
        String sql = "delete from kunden where kundennummer = ?";
        int update = jdbcTemplate.update(sql, id);
        return update;
    }

    public int EditKundeninfo(Kunden kunden,Integer id){
        String sql = "update kunden set kundenname = ?,Bilder = ?,Branche = ?,Standort= ?,Ansprechpartner = ?,Adress = ? where kundennummer = ?";
        int update = jdbcTemplate.update(sql, kunden.getKundenname(), kunden.getBilder(), kunden.getBranche(), kunden.getStandort(),
                kunden.getAnsprechpartner(), kunden.getAdress(), id);
        return update;
    }

    public List<Kunden> Kundenlist(){
        String sql = "select * from kunden,anforderung where kunden.kundensanforderungen = anforderung.Anforderung_id;";
        List<Kunden> kundenlist = jdbcTemplate.query(sql, new RowMapper<Kunden>() {
            @Override
            public Kunden mapRow(ResultSet resultSet, int i) throws SQLException {
                Kunden kunden = new Kunden();
                Anforderung anforderung = new Anforderung();
                kunden.setKundennummer(resultSet.getInt("kundennummer"));
                kunden.setKundenname(resultSet.getString("kundenname"));
                kunden.setKundensanforderung(resultSet.getInt("kundensanforderungen"));
                kunden.setEintragungszeit(resultSet.getDate("eintragungszeit"));
                kunden.setBilder(resultSet.getString("Bilder"));
                kunden.setStandort(resultSet.getString("Standort"));
                anforderung.setAnforderung_id(resultSet.getInt("Anforderung_id"));
                anforderung.setAnforderung_name(resultSet.getString("Anforderung_name"));
                anforderung.setAnforderung_beschreibung(resultSet.getString("Anforderung_beschreibung"));
                kunden.setAnforderung(anforderung);
                return kunden;
            }
        });
        return kundenlist;
    }

    public List<Kunden> showallinfoofkunden(){
        String sql = "select * from kunden";
        List<Kunden> kundenList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Kunden>(Kunden.class));
        return kundenList;
    }

    public Kunden kundenview(Integer kundennummer){
        String sql = "select * from kunden where kundennummer = ?";
        Kunden kunden = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Kunden>(Kunden.class),kundennummer);
        return kunden;
    }

    public int kundenAdd(Kunden kunden) {
        String sql = "insert into kunden (kundennummer,kundenname,Bilder," +
                "Standort,Branche,Ansprechpartner,Adress) values (?,?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, null, kunden.getKundenname(),
                kunden.getBilder(), kunden.getStandort(), kunden.getBranche(), kunden.getAnsprechpartner(),
                kunden.getAdress());
        return update;
    }

    public Integer sum(){
        String sql = "select count(kundennummer) from kunden;";
        Integer integer = jdbcTemplate.queryForObject(sql, int.class);
        return integer;
    }

    public List<Anforderung> anforderungs(Integer id){
        String sql = "select * from anforderung where Auftraggeber = ?;";
        List<Anforderung> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Anforderung>(Anforderung.class), id);
        return query;
    }
}
