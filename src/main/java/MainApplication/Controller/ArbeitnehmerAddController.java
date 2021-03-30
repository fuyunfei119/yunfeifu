package MainApplication.Controller;

import MainApplication.Bean.Abteilung;
import MainApplication.Bean.Arbeitnehmer;
import MainApplication.Service.AbteilungListService;
import MainApplication.Service.ArbeitnehmerAddService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class ArbeitnehmerAddController {

    @Resource
    private ArbeitnehmerAddService arbeitnehmerAddService;
    @Resource
    private AbteilungListService abteilungListService;

    @RequestMapping("/arbeitnehmerAdd")
    public String Add(HttpServletRequest httpServletRequest, Model model, Arbeitnehmer arbeitnehmer) throws IOException {
        Object name = httpServletRequest.getSession().getAttribute("name");
        Object abteilung = httpServletRequest.getSession().getAttribute("abteilung");
        Object bilder = httpServletRequest.getSession().getAttribute("bilder");
        model.addAttribute("getname",name);
        model.addAttribute("getabteilung",abteilung);
        model.addAttribute("bilder",bilder);

        List<Abteilung> abteilunglist = abteilungListService.abteilunglist();
        model.addAttribute("abteilunglist",abteilunglist);

        if (arbeitnehmer.getName()!=null){
            Arbeitnehmer arbeitnehmer1 = arbeitnehmer;
            int arbeitnehmeradd = arbeitnehmerAddService.arbeitnehmeradd(arbeitnehmer1,arbeitnehmer1.getName());
        }

        return "add-student";
    }

}
