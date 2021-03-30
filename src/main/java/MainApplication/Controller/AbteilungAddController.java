package MainApplication.Controller;

import MainApplication.Bean.Abteilung;
import MainApplication.Bean.Arbeitnehmer;
import MainApplication.Service.AbteilungAddService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AbteilungAddController {

    @Resource
    private AbteilungAddService abteilungAddService;

    @RequestMapping("/AbteilungAdd")
    public String AbteilungAdd(Abteilung abteilung, Model model, HttpServletRequest httpServletRequest){
        InboxController.UserMenueInfo(httpServletRequest,model);
        try {
            if (abteilung.getAbteilung_name()!=null){
                int abteilungAdd = abteilungAddService.AbteilungAdd(abteilung);
                System.out.println(abteilungAdd);
                return "forward:/AbteilungList";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error",e.getMessage());
            return "error-404";
        }

        return "add-department";
    }
}
