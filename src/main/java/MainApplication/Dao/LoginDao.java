package MainApplication.Dao;

import MainApplication.Bean.Abteilung;
import MainApplication.Bean.Anforderung;
import MainApplication.Bean.Arbeitnehmer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class LoginDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public int ArbeitnehmerDelete(Integer id){
        String sql = "delete from arbeitnehmer where id = ?";
        int update = jdbcTemplate.update(sql, id);
        return update;
    }

    public int ArbeitnehmerEditByName(Arbeitnehmer arbeitnehmer,String name){
        String sql = "update arbeitnehmer set name = ?,Mail = ?,telefonnummber = ?,Geschlechte = ? ,Abteilung_id = ?,Geburtsort = ?,Geburtsdatum = ?,Wohnungort = ?,Schulische_Ausbildung = ?,Berufliche_Ausbildung = ?,Studium = ?,Bilder = ? where name = ?";
        int update = jdbcTemplate.update(sql, arbeitnehmer.getName(), arbeitnehmer.getMail(), arbeitnehmer.getTelefonnummber(), arbeitnehmer.getGeschlechte(),
                arbeitnehmer.getAbteilung_id(), arbeitnehmer.getGeburtsort(), arbeitnehmer.getGeburtsdatum(), arbeitnehmer.getWohnungort(),
                arbeitnehmer.getSchulische_Ausbildung(), arbeitnehmer.getBerufliche_Ausbildung(), arbeitnehmer.getStudium(), arbeitnehmer.getBilder()
                ,name);
        return update;
    }

    public int ArbeitnehmerEditById(Arbeitnehmer arbeitnehmer, int id) {
        String sql = "update arbeitnehmer set name = ?,Mail = ?,telefonnummber = ?,Geschlechte = ? ,Abteilung_id = ?,Geburtsort = ?,Geburtsdatum = ?,Wohnungort = ?,Schulische_Ausbildung = ?,Berufliche_Ausbildung = ?,Studium = ?,Bilder = ? where id = ?";
        int update = jdbcTemplate.update(sql, arbeitnehmer.getName(), arbeitnehmer.getMail(), arbeitnehmer.getTelefonnummber(), arbeitnehmer.getGeschlechte(),
                arbeitnehmer.getAbteilung_id(), arbeitnehmer.getGeburtsort(), arbeitnehmer.getGeburtsdatum(), arbeitnehmer.getWohnungort(),
                arbeitnehmer.getSchulische_Ausbildung(), arbeitnehmer.getBerufliche_Ausbildung(), arbeitnehmer.getStudium(), arbeitnehmer.getBilder()
                ,id);

        return update;
    }

    public int ArbeitnehmerAdd(Arbeitnehmer arbeitnehmer){
        String sql = "insert into arbeitnehmer (id,name,password,Mail,telefonnummber," +
                "eintragungszeit,Geschlechte,Abteilung_id,Geburtsort,Geburtsdatum," +
                "Wohnungort,Bilder,Schulische_Ausbildung,Berufliche_Ausbildung," +
                "Studium) "+
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql,null,arbeitnehmer.getName(),null,arbeitnehmer.getMail(),arbeitnehmer.getTelefonnummber(),
                new Timestamp(System.currentTimeMillis()),arbeitnehmer.getGeschlechte(),arbeitnehmer.getAbteilung_id(),arbeitnehmer.getGeburtsort(),arbeitnehmer.getGeburtsdatum(),
                arbeitnehmer.getWohnungort(),arbeitnehmer.getBilder(),arbeitnehmer.getSchulische_Ausbildung(),arbeitnehmer.getBerufliche_Ausbildung(),
                arbeitnehmer.getStudium());
        return update;
    }

    public Arbeitnehmer findById(Integer id){
        String sql = "select * from arbeitnehmer where id = ?";
        try {
            Arbeitnehmer arbeitnehmer = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Arbeitnehmer>(Arbeitnehmer.class), id);
            return arbeitnehmer;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Arbeitnehmer findbyName(String  name){
        String sql = "select * from arbeitnehmer where name = ?";
        try {
            Arbeitnehmer arbeitnehmer = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Arbeitnehmer>(Arbeitnehmer.class), name);
            return arbeitnehmer;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Abteilung findbyId(int abteilungsid,String name){
        String sql = "select * from arbeitnehmer as an,abteilung as ab where ? = ab.Abteilung_id and name = ?;";
        Abteilung abteilung = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Abteilung>(Abteilung.class),abteilungsid,name);
        return abteilung;
    }

    public void passwordandern(String Newpassword,String name){
        String sql = "update arbeitnehmer set password = ? where name = ?";
        jdbcTemplate.update(sql,Newpassword,name);
    }

    public List<Arbeitnehmer> findallpersoninformations(){
        String sql = "select * from arbeitnehmer as an,abteilung as ab where an.Abteilung_id = ab.Abteilung_id;";
        List<Arbeitnehmer> Arbeitnehmerlist = jdbcTemplate.query(sql, new RowMapper<Arbeitnehmer>() {
            @Override
            public Arbeitnehmer mapRow(ResultSet resultSet, int i) throws SQLException {
                Arbeitnehmer arbeitnehmer = new Arbeitnehmer();
                Abteilung abteilung = new Abteilung();
                arbeitnehmer.setId(resultSet.getInt("id"));
                arbeitnehmer.setName(resultSet.getString("name"));
                arbeitnehmer.setPassword(resultSet.getString("password"));
                arbeitnehmer.setMail(resultSet.getString("Mail"));
                arbeitnehmer.setTelefonnummber(resultSet.getString("telefonnummber"));
                arbeitnehmer.setEintragungszeit(resultSet.getDate("eintragungszeit"));
                arbeitnehmer.setGeschlechte(resultSet.getString("Geschlechte"));
                arbeitnehmer.setAbteilung_id(resultSet.getInt("Abteilung_id"));
                arbeitnehmer.setGeburtsort(resultSet.getString("Geburtsort"));
                arbeitnehmer.setGeburtsdatum(resultSet.getDate("Geburtsdatum"));
                arbeitnehmer.setWohnungort(resultSet.getString("Wohnungort"));
                arbeitnehmer.setBilder(resultSet.getString("Bilder"));
                arbeitnehmer.setGehalt(resultSet.getDouble("Gehalt"));
                abteilung.setAbteilung_id(resultSet.getInt("Abteilung_id"));
                abteilung.setAbteilung_name(resultSet.getString("Abteilung_name"));
                abteilung.setAbteilung_beschreibung(resultSet.getString("Abteilung_beschreibung"));
                arbeitnehmer.setAbteilung(abteilung);
                return arbeitnehmer;
            }
        });
        return Arbeitnehmerlist;
    }

    public Integer sum(){
        String sql = "select count(id) from arbeitnehmer";
        Integer integer = jdbcTemplate.queryForObject(sql, int.class);
        return integer;
    }

    public List<Arbeitnehmer> gehalt(){
        String sql = "select abteilung.Abteilung_id,abteilung.Abteilung_name,arbeitnehmer.Gehalt from arbeitnehmer,abteilung where arbeitnehmer.Abteilung_id = abteilung.Abteilung_id order by Abteilung_name;";

        List<Arbeitnehmer> arbeitnehmers = jdbcTemplate.query(sql, new RowMapper<Arbeitnehmer>() {
            @Override
            public Arbeitnehmer mapRow(ResultSet resultSet, int i) throws SQLException {
                Arbeitnehmer arbeitnehmer = new Arbeitnehmer();
                Abteilung abteilung = new Abteilung();
                abteilung.setAbteilung_name(resultSet.getString("Abteilung_name"));
                arbeitnehmer.setAbteilung(abteilung);
                arbeitnehmer.setGehalt(resultSet.getDouble("Gehalt"));
                return arbeitnehmer;
            }
        });
        return arbeitnehmers;
    }

    public Integer gehaltsum(){
        String sql = "select sum(Gehalt) from arbeitnehmer;";
        Integer integer = jdbcTemplate.queryForObject(sql, int.class);
        return integer;
    }

    public List<Map<String, Integer>> echartsbydatebygehalt(){
        String sql ="select date_format(arbeitnehmer.eintragungszeit,\"%m\"),sum(arbeitnehmer.Gehalt) from arbeitnehmer GROUP BY date_format(arbeitnehmer.eintragungszeit,\"%m\");";
        List<Map<String, Integer>> query = jdbcTemplate.query(sql, new RowMapper<Map<String, Integer>>() {
            @Override
            public Map<String, Integer> mapRow(ResultSet resultSet, int i) throws SQLException {
                Map<String, Integer> map = new HashMap<>();
                Integer integer = resultSet.getInt("sum(arbeitnehmer.Gehalt)");
                String date = resultSet.getString("date_format(arbeitnehmer.eintragungszeit,\"%m\")");
                map.put(date, integer);
                return map;
            }
        });
        return query;
    }

    public List<Integer> ecahrtsbydatebyumsatz(){
        String sql = "select date_format(anforderung.eintragungszeit,\"%m\"),sum(anforderung.zu_gewinnen_Umsatz) from anforderung GROUP BY date_format(anforderung.eintragungszeit,\"%m\");";
        List<Integer> query = jdbcTemplate.query(sql, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer integer = resultSet.getInt("sum(anforderung.zu_gewinnen_Umsatz)");
                return integer;
            }
        });
        return query;
    }

    public List<String> charts2abteilung(){
        String sql = "select abteilung.Abteilung_name from anforderung,abteilung where abteilung.Abteilung_id = anforderung.Abteilung_id;";
        List<String> stringList = jdbcTemplate.query(sql, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                String string = resultSet.getString("Abteilung_name");
                return string;
            }
        });
        return stringList;
    }

    public List<Double> chartsumsatz(){
        String sql = "select anforderung.zu_gewinnen_Umsatz from anforderung,abteilung where abteilung.Abteilung_id = anforderung.Abteilung_id;\n";
        List<Double> zu_gewinnen_umsatz = jdbcTemplate.query(sql, new RowMapper<Double>() {
            @Override
            public Double mapRow(ResultSet resultSet, int i) throws SQLException {
                Double umsatz = resultSet.getDouble("zu_gewinnen_Umsatz");
                return umsatz;
            }
        });
        return zu_gewinnen_umsatz;
    }

    public List<Anforderung> anforderungs(String id){
        String sql = "select * from anforderung where Arbeitnehmer = ?;";
        List<Anforderung> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Anforderung>(Anforderung.class), id);
        return query;
    }
}
