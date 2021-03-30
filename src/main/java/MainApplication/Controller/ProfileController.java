package MainApplication.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {


    @RequestMapping("/profile")
    public String profile(HttpServletRequest httpServletRequest,Model model){
        Object name = httpServletRequest.getSession().getAttribute("name");
        Object abteilung = httpServletRequest.getSession().getAttribute("abteilung");
        Object bilder = httpServletRequest.getSession().getAttribute("bilder");
        Object geburtsdatum = httpServletRequest.getSession().getAttribute("geburtsdatum");
        Object mail = httpServletRequest.getSession().getAttribute("mail");
        Object telefonnummber = httpServletRequest.getSession().getAttribute("telefonnummber");
        Object wohnungsort = httpServletRequest.getSession().getAttribute("wohnungsort");
        model.addAttribute("getname",name);
        model.addAttribute("getabteilung",abteilung);
        model.addAttribute("bilder",bilder);
        model.addAttribute("geburtsdatum",geburtsdatum);
        model.addAttribute("mail",mail);
        model.addAttribute("telefonnummer",telefonnummber);
        model.addAttribute("wohnungsort",wohnungsort);
        return "profile";
    }
}
