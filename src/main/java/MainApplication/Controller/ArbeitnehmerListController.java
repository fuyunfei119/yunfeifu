package MainApplication.Controller;

import MainApplication.Bean.Arbeitnehmer;
import MainApplication.Service.ArbeitnehmerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ArbeitnehmerListController {

    @Resource
    private ArbeitnehmerService arbeitnehmerService;

    @RequestMapping("/arbeitnehmerlist")
    public String arbeitnehmerlist(HttpServletRequest httpServletRequest, Model model){
        Object name = httpServletRequest.getSession().getAttribute("name");
        Object abteilung = httpServletRequest.getSession().getAttribute("abteilung");
        Object bilder = httpServletRequest.getSession().getAttribute("bilder");
        model.addAttribute("getname",name);
        model.addAttribute("getabteilung",abteilung);
        model.addAttribute("bilder",bilder);
        List<Arbeitnehmer> arbeitnehmerlist = arbeitnehmerService.findallpersoninformations();
        model.addAttribute("arbeitnehmerlist",arbeitnehmerlist);
        return "students";
    }
}
