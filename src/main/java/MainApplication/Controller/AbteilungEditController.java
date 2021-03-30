package MainApplication.Controller;

import MainApplication.Bean.Abteilung;
import MainApplication.Service.AbteilungEditService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AbteilungEditController {

    @Resource
    private AbteilungEditService abteilungEditService;

    @RequestMapping("/AbteilungEdit")
    public String AbteilungEdit(Integer id, Model model,HttpServletRequest httpServletRequest){
        InboxController.UserMenueInfo(httpServletRequest,model);
        httpServletRequest.getSession().setAttribute("abteilungeditid",id);
        Abteilung abteilung = abteilungEditService.abteilungedit(id);
        model.addAttribute("Abteilung_name",abteilung.getAbteilung_name());
        model.addAttribute("Abteilung_beschreibung",abteilung.getAbteilung_beschreibung());
        return "edit-department";
    }

    @RequestMapping("/runabteilungEdit")
    public String runabteilungedit(Abteilung abteilung, HttpServletRequest httpServletRequest,Model model){
        InboxController.UserMenueInfo(httpServletRequest,model);
        Integer id = (Integer) httpServletRequest.getSession().getAttribute("abteilungeditid");
        if (abteilung.getAbteilung_name()!=null){
            int runedit = abteilungEditService.runedit(abteilung, id);
            System.out.println(runedit);
        }
        return "forward:/AbteilungList";
    }
}
