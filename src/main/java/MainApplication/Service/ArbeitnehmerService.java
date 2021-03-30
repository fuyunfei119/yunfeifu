package MainApplication.Service;

import MainApplication.Bean.Arbeitnehmer;
import MainApplication.Dao.LoginDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArbeitnehmerService {

    @Resource
    private LoginDao loginDao;

    public List<Arbeitnehmer> findallpersoninformations(){
        List<Arbeitnehmer> arbeitnehmerList = loginDao.findallpersoninformations();
        return arbeitnehmerList;
    }
}
