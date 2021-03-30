package MainApplication.Controller;

import MainApplication.Bean.Abteilung;
import MainApplication.Bean.Anforderung;
import MainApplication.Bean.Arbeitnehmer;
import MainApplication.Bean.Kunden;
import MainApplication.Service.AbteilungListService;
import MainApplication.Service.AnforderungAddService;
import MainApplication.Service.ArbeitnehmerService;
import MainApplication.Service.KundenListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AnforderungAddController {

    @Resource
    private AnforderungAddService anforderungAddService;
    @Resource
    private KundenListService kundenListService;
    @Resource
    private AbteilungListService abteilungListService;
    @Resource
    private ArbeitnehmerService arbeitnehmerService;

    @RequestMapping("/AnforderungAdd")
    public String anforderungAddController(Anforderung anforderung, Model model, HttpServletRequest httpServletRequest){
        InboxController.UserMenueInfo(httpServletRequest,model);

        List<Kunden> kundenList = kundenListService.showallinfo();
        model.addAttribute("kundenList",kundenList);

        List<Abteilung> abteilunglist = abteilungListService.abteilunglist();
        model.addAttribute("Abteilunglist",abteilunglist);

        List<Arbeitnehmer> findallpersoninformations = arbeitnehmerService.findallpersoninformations();
        model.addAttribute("Arbeitnehmerlist",findallpersoninformations);

        if (anforderung.getAnforderung_name()!=null){
            int addService = anforderungAddService.anforderungAddService(anforderung);
            System.out.println(addService);
        }
        return "add-subject";
    }
}
