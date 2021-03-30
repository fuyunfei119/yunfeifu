package MainApplication.Service;

import MainApplication.Bean.Kunden;
import MainApplication.Dao.KundenDao;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Service
public class KundenAddService {

    @Resource
    private KundenDao kundenDao;

    public int KundenAddervice(Kunden kunden) throws Exception {

        if (kunden.getBranche().equals("Branche Auswählen")){
            throw new Exception("Bitte wählen Sie ihre Branche!!!");
        }
        if (Objects.equals(kunden.getUploadfile().getOriginalFilename(), "")){
            throw new Exception("Sie haben noch kein Bilder hochgeladen!!!");
        }else {
            kunden.setBilder("assets/img/Unternehmensprofiles/"+kunden.getKundenname()+".jpg");
            kunden.getUploadfile().transferTo(new File("D:\\IdeaProjects\\CRM\\src\\main\\resources\\static\\assets\\img\\Unternehmensprofiles\\"+kunden.getKundenname()+".jpg"));
        }

        int kundenAdd = kundenDao.kundenAdd(kunden);
        return kundenAdd;
    }
}
