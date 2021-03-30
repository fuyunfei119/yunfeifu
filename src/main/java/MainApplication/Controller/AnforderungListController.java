package MainApplication.Controller;

import MainApplication.Bean.Anforderung;
import MainApplication.Service.AnforderungListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AnforderungListController {

    @Resource
    private AnforderungListService anforderungListService;

    @RequestMapping("/AnforderungList")
    public String anforderungListController(Model model, HttpServletRequest httpServletRequest){
        InboxController.UserMenueInfo(httpServletRequest,model);
        List<Anforderung> anforderungslist = anforderungListService.anforderungListService();
        model.addAttribute("anforderungslist",anforderungslist);
        return "subjects";
    }
}
