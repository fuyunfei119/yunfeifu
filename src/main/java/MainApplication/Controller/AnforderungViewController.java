package MainApplication.Controller;

import MainApplication.Bean.Anforderung;
import MainApplication.Dao.AnforderungDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AnforderungViewController {

    @Resource
    private AnforderungDao anforderungDao;

    @RequestMapping("/AnforderungView")
    public String anforderungViewController(Integer id, Model model, HttpServletRequest httpServletRequest){
        InboxController.UserMenueInfo(httpServletRequest,model);
        if (id==null){
            Anforderung anforderung = anforderungDao.anforderungview(1);
            model.addAttribute("info",anforderung);
        }
        Anforderung anforderung = anforderungDao.anforderungview(id);
        model.addAttribute("info",anforderung);
        return "subject-details";
    }
}
