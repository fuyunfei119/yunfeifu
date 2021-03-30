package MainApplication.Controller;

import MainApplication.Bean.Abteilung;
import MainApplication.Dao.AbteilungDao;
import MainApplication.Service.AbteilungListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@Controller
public class AbteilungListController {

    @Resource
    private AbteilungListService abteilungListService;
    @Resource
    private AbteilungDao abteilungDao;

    @RequestMapping("/AbteilungList")
    public String AbteilungList(Model model, HttpServletRequest httpServletRequest){
        InboxController.UserMenueInfo(httpServletRequest,model);
        List<Abteilung> abteilunglist = abteilungListService.abteilunglist();
        model.addAttribute("abteilunglist",abteilunglist);
        return "departments";
    }
}
