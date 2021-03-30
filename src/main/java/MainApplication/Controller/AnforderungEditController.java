package MainApplication.Controller;

import MainApplication.Bean.Abteilung;
import MainApplication.Bean.Anforderung;
import MainApplication.Bean.Arbeitnehmer;
import MainApplication.Bean.Kunden;
import MainApplication.Dao.AnforderungDao;
import MainApplication.Service.AbteilungListService;
import MainApplication.Service.AnforderungEditService;
import MainApplication.Service.ArbeitnehmerService;
import MainApplication.Service.KundenListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AnforderungEditController {

    @Resource
    private AnforderungEditService anforderungEditService;
    @Resource
    private AnforderungDao anforderungDao;
    @Resource
    private KundenListService kundenListService;
    @Resource
    private AbteilungListService abteilungListService;
    @Resource
    private ArbeitnehmerService arbeitnehmerService;

    @RequestMapping("/AnforderungEdit")
    public String anforderungEditController(Integer id, Model model, HttpServletRequest httpServletRequest){
        InboxController.UserMenueInfo(httpServletRequest,model);

        List<Kunden> kundenList = kundenListService.showallinfo();
        model.addAttribute("kundenList",kundenList);

        Anforderung anforderung = anforderungEditService.anforderungEditService(id);
        model.addAttribute("anforderung",anforderung);

        List<Abteilung> abteilunglist = abteilungListService.abteilunglist();
        model.addAttribute("Abteilunglist",abteilunglist);

        List<Arbeitnehmer> findallpersoninformations = arbeitnehmerService.findallpersoninformations();
        model.addAttribute("Arbeitnehmerlist",findallpersoninformations);

        httpServletRequest.getSession().setAttribute("anforderungid",id);
        return "edit-subject";
    }

    @RequestMapping("/runanforderungedit")
    public String run(Anforderung anforderung,HttpServletRequest httpServletRequest){
        Integer anforderungid = (Integer) httpServletRequest.getSession().getAttribute("anforderungid");
        if (anforderung.getAnforderung_name()!=null){
            int runedit = anforderungDao.runedit(anforderung, anforderungid);
        }
        return "forward:/AnforderungList";
    }
}
