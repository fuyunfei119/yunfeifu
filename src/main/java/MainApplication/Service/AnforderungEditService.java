package MainApplication.Service;

import MainApplication.Bean.Anforderung;
import MainApplication.Dao.AnforderungDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnforderungEditService {

    @Resource
    private AnforderungDao anforderungDao;

    public Anforderung anforderungEditService(Integer id){
        Anforderung nativeinfo = anforderungDao.nativeinfo(id);
        return nativeinfo;
    }
}
