package MainApplication.Service;

import MainApplication.Bean.Kunden;
import MainApplication.Dao.KundenDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;

@Service
public class KundenDeleteService {

    @Resource
    private KundenDao kundenDao;

    public int Kundendelete(Integer id) throws InterruptedException {
        Kunden kundenview = kundenDao.kundenview(id);
        File file = new File("D:\\IdeaProjects\\CRM\\src\\main\\resources\\static\\assets\\img\\Unternehmensprofiles");
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.getName().contains(kundenview.getKundenname())){
                f.delete();
            }
        }
        Thread.sleep(1000);

        int deleteKunden = kundenDao.DeleteKunden(id);
        return deleteKunden;
    }
}
