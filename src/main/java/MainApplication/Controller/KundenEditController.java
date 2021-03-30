package MainApplication.Controller;

import MainApplication.Bean.Kunden;
import MainApplication.Service.KundenEditService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class KundenEditController {

    @Resource
    private KundenEditService kundenEditService;

    @RequestMapping("/KundenEdit")
    public String kundenEdit(Integer kundennummer, Model model, Kunden kunden, HttpServletRequest httpServletRequest){

        httpServletRequest.getSession().setAttribute("kundenEditid",kundennummer);

        Kunden nativeinfo = kundenEditService.Nativeinfo(kundennummer);

        model.addAttribute("kundenname",nativeinfo.getKundenname());
        model.addAttribute("Standort",nativeinfo.getStandort());
        model.addAttribute("Ansprechpartner",nativeinfo.getAnsprechpartner());
        model.addAttribute("Adress",nativeinfo.getAdress());

        return "edit-teacher";
    }


    @RequestMapping("/runkundenEdit")
    public String runkundenEdit(HttpServletRequest httpServletRequest,Kunden kunden,Model model){
        Integer id = (Integer) httpServletRequest.getSession().getAttribute("kundenEditid");

        int editinfo = 0;
        try {
            editinfo = kundenEditService.Editinfo(kunden, id);
        } catch (Exception e) {
            Object name1 = httpServletRequest.getSession().getAttribute("name");
            Object abteilung = httpServletRequest.getSession().getAttribute("abteilung");
            Object bilder = httpServletRequest.getSession().getAttribute("bilder");
            model.addAttribute("getname",name1);
            model.addAttribute("getabteilung",abteilung);
            model.addAttribute("bilder",bilder);
            model.addAttribute("error",e.getMessage());
            model.addAttribute("getid",id);
            return "error-404";

        }
        return "forward:/Kundenlist";
    }

}
