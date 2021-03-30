package MainApplication.Service;

import MainApplication.Bean.Kunden;
import MainApplication.Dao.KundenDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class KundenListService {

    @Resource
    private KundenDao kundenDao;

    public List<Kunden> kundenlistservice(){
        List<Kunden> kundenlist = kundenDao.Kundenlist();
        return kundenlist;
    }

    public List<Kunden> showallinfo(){
        List<Kunden> kundenList = kundenDao.showallinfoofkunden();
        return kundenList;
    }
}
