package MainApplication.Service;

import MainApplication.Bean.Anforderung;
import MainApplication.Dao.AnforderungDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnforderungAddService {

    @Resource
    private AnforderungDao anforderungDao;

    public int anforderungAddService(Anforderung anforderung){
        return anforderungDao.anforderungadd(anforderung);
    }
}
