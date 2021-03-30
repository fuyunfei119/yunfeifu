package MainApplication.Dao;

import MainApplication.Bean.Abteilung;
import MainApplication.Bean.Kunden;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AbteilungDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<Abteilung> abteilungList(){
        String sql = "select * from abteilung";
        List<Abteilung> Abteilunglist = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Abteilung>(Abteilung.class));
        return Abteilunglist;
    }

    public int abteilungAdd(Abteilung abteilung){
        String sql = "insert into abteilung (Abteilung_id,Abteilung_name,Abteilung_beschreibung) " +
                "values (?,?,?) ";
        int update = jdbcTemplate.update(sql, null, abteilung.getAbteilung_name(), abteilung.getAbteilung_beschreibung());
        return update;
    }

    public Abteilung nativeinfo(Integer id){
        String sql = "select * from abteilung where Abteilung_id = ?";
        Abteilung abteilung = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Abteilung>(Abteilung.class), id);
        return abteilung;
    }

    public int abteilungedit(Abteilung abteilung,Integer id){
        String sql = "update abteilung set Abteilung_name = ?,Abteilung_beschreibung = ? where Abteilung_id = ?";
        int update = jdbcTemplate.update(sql, abteilung.getAbteilung_name(), abteilung.getAbteilung_beschreibung(), id);
        return update;
    }

    public int abteilungdelete(Integer id){
        String sql = "delete from abteilung where Abteilung_id = ?";
        int update = jdbcTemplate.update(sql, id);
        return update;
    }

    public Double sum(){
        String sql = "select count(id) from arbeitnehmer";
        return jdbcTemplate.queryForObject(sql, Double.class);
    }

    public Integer sumof(){
        String sql = "select count(abteilung.Abteilung_id) from abteilung;";
        Integer integer = jdbcTemplate.queryForObject(sql, int.class);
        return integer;
    }
}
