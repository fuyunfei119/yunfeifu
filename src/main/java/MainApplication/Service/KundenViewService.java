package MainApplication.Service;

import MainApplication.Bean.Anforderung;
import MainApplication.Bean.Kunden;
import MainApplication.Dao.KundenDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class KundenViewService {

    @Resource
    private KundenDao kundenDao;

    public Kunden kundenViewService(Integer kundennummer){
        Kunden kunden = kundenDao.kundenview(kundennummer);
        return kunden;
    }

    public List<Anforderung> anforderungs(Integer id){
        return kundenDao.anforderungs(id);
    }
}
