package MainApplication.Service;

import MainApplication.Bean.Kunden;
import MainApplication.Dao.KundenDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.Objects;

@Service
public class KundenEditService {

    @Resource
    private KundenDao kundenDao;

    public Kunden Nativeinfo(Integer Kundennummer){
        Kunden kundenview = kundenDao.kundenview(Kundennummer);
        return kundenview;
    }

    public int Editinfo(Kunden kunden,Integer id) throws Exception {
        if (kunden.getBranche().equals("Branche Auswählen")){
            throw new Exception("Bitte wählen Sie ihre Branche!!!");
        }
        if (Objects.equals(kunden.getUploadfile().getOriginalFilename(), "")){
            throw new Exception("Sie haben noch kein Bilder hochgeladen!!!");
        }else {
            kunden.setBilder("assets/img/Unternehmensprofiles/"+kunden.getKundenname()+".jpg");
            File file = new File("D:\\IdeaProjects\\CRM\\src\\main\\resources\\static\\assets\\img\\Unternehmensprofiles");
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.getName().contains(kunden.getKundenname()+".jpg")){
                    boolean delete = f.delete();
                    if (delete){
                        System.out.println("删除成功");
                    }else {
                        System.out.println("删除失败");
                    }
                }
            }
            Thread.sleep(2000);
            kunden.getUploadfile().transferTo(new File("D:/IdeaProjects/CRM/src/main/resources/static/assets/img/Unternehmensprofiles/"+kunden.getKundenname()+".jpg"));
        }

        int kundeninfo = kundenDao.EditKundeninfo(kunden, id);
        return kundeninfo;
    }
}
