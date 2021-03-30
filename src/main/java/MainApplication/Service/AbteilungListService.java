package MainApplication.Service;

import MainApplication.Bean.Abteilung;
import MainApplication.Dao.AbteilungDao;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class AbteilungListService {

    @Resource
    private AbteilungDao abteilungDao;

    public List<Abteilung> abteilunglist(){
        List<Abteilung> abteilungs = abteilungDao.abteilungList();
        return abteilungs;
    }
}
