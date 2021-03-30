package MainApplication.Controller;

import MainApplication.Dao.AnforderungDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AnforderungDeleteController {

    @Resource
    private AnforderungDao anforderungDao;

    @RequestMapping("/AnforderungDelete")
    public String anforderungdeleteController(Integer id, HttpServletRequest httpServletRequest, Model model){
        InboxController.UserMenueInfo(httpServletRequest,model);
        if (id!=1) {
            int anforderungdelete = anforderungDao.anforderungdelete(id);
            System.out.println(anforderungdelete);
        }
        return "forward:/AnforderungList";
    }
}
