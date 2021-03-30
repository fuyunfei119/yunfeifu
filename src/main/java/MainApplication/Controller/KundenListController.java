package MainApplication.Controller;

import MainApplication.Bean.Kunden;
import MainApplication.Service.KundenListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class KundenListController {

    @Resource
    private KundenListService kundenListService;

    @RequestMapping("/Kundenlist")
    public String Kundenlist(Model model, HttpServletRequest httpServletRequest){
        InboxController.UserMenueInfo(httpServletRequest,model);
        List<Kunden> kundenList = kundenListService.showallinfo();
        model.addAttribute("kundenlist",kundenList);
        return "teachers";
    }
}
