package MainApplication.Service;

import MainApplication.Bean.Abteilung;
import MainApplication.Dao.AbteilungDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AbteilungAddService {

    @Resource
    private AbteilungDao abteilungDao;

    public int AbteilungAdd(Abteilung abteilung) throws Exception {
        List<Abteilung> abteilungs = abteilungDao.abteilungList();
        for (int i = 0; i < abteilungs.size(); i++) {
            if (abteilungs.get(i).getAbteilung_name().equals(abteilung.getAbteilung_name())){
                throw new Exception("Die Abteilung besteht schon!!!");
            }
        }
        int abteilungAdd = abteilungDao.abteilungAdd(abteilung);
        return abteilungAdd;
    }
}
