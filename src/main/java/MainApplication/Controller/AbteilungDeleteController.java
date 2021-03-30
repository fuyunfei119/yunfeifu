package MainApplication.Controller;

import MainApplication.Dao.AbteilungDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AbteilungDeleteController {

    @Resource
    private AbteilungDao abteilungDao;

    @RequestMapping("/AbteilungDelete")
    public String abteilungdelete(Integer id, HttpServletRequest httpServletRequest, Model model){
        InboxController.UserMenueInfo(httpServletRequest,model);
        int abteilungdelete = abteilungDao.abteilungdelete(id);
        System.out.println(abteilungdelete);
        return "forward:/AbteilungList";
    }

}
