package MainApplication.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class InboxController {

    @RequestMapping("/inbox")
    public String inbox(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model){
        UserMenueInfo(httpServletRequest, model);
        return "inbox";
    }

    static void UserMenueInfo(HttpServletRequest httpServletRequest, Model model) {
        Object name = httpServletRequest.getSession().getAttribute("name");
        Object abteilung = httpServletRequest.getSession().getAttribute("abteilung");
        Object bilder = httpServletRequest.getSession().getAttribute("bilder");
        model.addAttribute("getname",name);
        model.addAttribute("getabteilung",abteilung);
        model.addAttribute("bilder",bilder);
    }
}
