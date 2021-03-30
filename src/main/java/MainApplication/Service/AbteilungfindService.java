package MainApplication.Service;

import MainApplication.Bean.Abteilung;
import MainApplication.Bean.Anforderung;
import MainApplication.Dao.LoginDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AbteilungfindService {

    @Resource
    private LoginDao loginDao;

    public Abteilung findAbteilung(int abteilungsid,String name){
        Abteilung abteilung = loginDao.findbyId(abteilungsid,name);
        return abteilung;
    }

    public List<Anforderung> anforderungs(String id){
        List<Anforderung> anforderungs = loginDao.anforderungs(id);
        return anforderungs;
    }
}
