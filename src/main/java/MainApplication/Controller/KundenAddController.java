package MainApplication.Controller;

import MainApplication.Bean.Kunden;
import MainApplication.Service.KundenAddService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class KundenAddController {

    @Resource
    private KundenAddService kundenAddService;

    @RequestMapping("/KundenAdd")
    public String KundenAdd(Kunden kunden, HttpServletRequest httpServletRequest, Model model) throws IOException {
        Object name = httpServletRequest.getSession().getAttribute("name");
        Object abteilung = httpServletRequest.getSession().getAttribute("abteilung");
        Object bilder = httpServletRequest.getSession().getAttribute("bilder");
        model.addAttribute("getname",name);
        model.addAttribute("getabteilung",abteilung);
        model.addAttribute("bilder",bilder);

        if (kunden.getKundenname()!=null){
            try {
               int kundenAddervice = kundenAddService.KundenAddervice(kunden);
               return "forward:/Kundenlist";
            } catch (Exception e) {
                model.addAttribute("error",e.getMessage());
                return "error-404";
            }
        }
        return "add-teacher";
    }
}
