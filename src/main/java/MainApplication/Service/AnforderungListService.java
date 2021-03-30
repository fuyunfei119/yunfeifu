package MainApplication.Service;

import MainApplication.Bean.Anforderung;
import MainApplication.Dao.AnforderungDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnforderungListService {

    @Resource
    private AnforderungDao anforderungDao;

    public List<Anforderung> anforderungListService(){
        List<Anforderung> anforderungList = anforderungDao.showallinfo();
        return anforderungList;
    }
}
