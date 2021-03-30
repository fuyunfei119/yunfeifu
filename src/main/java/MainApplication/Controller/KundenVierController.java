package MainApplication.Controller;

import MainApplication.Bean.Anforderung;
import MainApplication.Bean.Kunden;
import MainApplication.Service.KundenViewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class KundenVierController {

    @Resource
    private KundenViewService kundenViewService;

    @RequestMapping("/KundenView")
    public String KundenView(Integer kundennummer, Model model, HttpServletRequest httpServletRequest){

        InboxController.UserMenueInfo(httpServletRequest,model);

        if (kundennummer==null){
            Kunden kunden = kundenViewService.kundenViewService(2);
            model.addAttribute("Bilder",kunden.getBilder());
            model.addAttribute("Name",kunden.getKundenname());
            long time = System.currentTimeMillis()-kunden.getEintragungszeit().getTime();
            int time1 = (int) (time/1000/60/60/24);
            String url = "https://www."+kunden.getKundenname()+".de";
            model.addAttribute("url",url);
            String standorturl = "https://www.google.de/maps/place/"+kunden.getStandort();
            model.addAttribute("standorturl",standorturl);
            String finaltime = time1+" Tage";
            model.addAttribute("Tage",finaltime);
            model.addAttribute("Standort",kunden.getStandort());
            model.addAttribute("Branche",kunden.getBranche());
            String replace = kunden.getAnsprechpartner().replace(";", "</br>");
            model.addAttribute("Ansprechpartner",replace);
            String replace1 = kunden.getAdress().replace(";", "</br>");
            model.addAttribute("Adress",replace1);

            List<Anforderung> anforderungs = kundenViewService.anforderungs(2);
            model.addAttribute("anforderungslist",anforderungs);

            return "teacher-details";
        }

        Kunden kunden = kundenViewService.kundenViewService(kundennummer);
        model.addAttribute("Bilder",kunden.getBilder());
        model.addAttribute("Name",kunden.getKundenname());
        long time = System.currentTimeMillis()-kunden.getEintragungszeit().getTime();
        int time1 = (int) (time/1000/60/60/24);
        String finaltime = time1+" Tage";
        String url = "https://www."+kunden.getKundenname()+".de";
        model.addAttribute("url",url);
        String standorturl = "https://www.google.de/maps/place/"+kunden.getStandort();
        model.addAttribute("standorturl",standorturl);
        model.addAttribute("Tage",finaltime);
        model.addAttribute("Standort",kunden.getStandort());
        model.addAttribute("Branche",kunden.getBranche());
        String replace = kunden.getAnsprechpartner().replace(";", "</br>");
        model.addAttribute("Ansprechpartner",replace);
        String replace1 = kunden.getAdress().replace(";", "</br>");
        model.addAttribute("Adress",replace1);

        List<Anforderung> anforderungs = kundenViewService.anforderungs(kundennummer);
        model.addAttribute("anforderungslist",anforderungs);

        return "teacher-details";
    }
}
