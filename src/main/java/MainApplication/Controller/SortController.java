package MainApplication.Controller;

import MainApplication.Bean.Abteilung;
import MainApplication.Service.AbteilungListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Controller
public class SortController {

    @Resource
    private AbteilungListService abteilungListService;

    @RequestMapping("/Sort")
    public String Sort(Model model){
        List<Abteilung> abteilunglist = abteilungListService.abteilunglist();
        Collections.sort(abteilunglist);
        model.addAttribute("abteilunglistdesc",abteilunglist);
        Boolean Sort = true;
        model.addAttribute("desc",Sort);
        return "forward:/AbteilungList";
    }
}
