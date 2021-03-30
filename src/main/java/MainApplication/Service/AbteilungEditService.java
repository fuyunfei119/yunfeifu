package MainApplication.Service;

import MainApplication.Bean.Abteilung;
import MainApplication.Dao.AbteilungDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AbteilungEditService {

    @Resource
    private AbteilungDao abteilungDao;

    public Abteilung abteilungedit(Integer id){
        return abteilungDao.nativeinfo(id);
    }

    public int runedit(Abteilung abteilung,Integer id){
        return abteilungDao.abteilungedit(abteilung, id);
    }
}
