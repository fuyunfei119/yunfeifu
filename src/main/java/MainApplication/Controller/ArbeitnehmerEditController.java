package MainApplication.Controller;

import MainApplication.Bean.Arbeitnehmer;
import MainApplication.Dao.LoginDao;
import MainApplication.Service.ArbeitnehmerEditService;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ArbeitnehmerEditController {

    @Resource
    private ArbeitnehmerEditService arbeitnehmerEditService;
    @Resource
    private LoginDao loginDao;

    @RequestMapping("/arbeitnehmerEdit")
    public String arbeitnehmerEdit(Model model, Integer id,HttpServletRequest httpServletRequest) {
            InboxController.UserMenueInfo(httpServletRequest,model);
            Arbeitnehmer arbeitnehmer = arbeitnehmerEditService.NativeInfo(id);
            httpServletRequest.getSession().setAttribute("getid",id);
            model.addAttribute("getname", arbeitnehmer.getName());
            model.addAttribute("Telefonnummer", arbeitnehmer.getTelefonnummber());
            model.addAttribute("Mail", arbeitnehmer.getMail());
            model.addAttribute("Geschlechte", arbeitnehmer.getGeschlechte());
            model.addAttribute("Geburtsdatum", arbeitnehmer.getGeburtsdatum());
            model.addAttribute("Geburtsort", arbeitnehmer.getGeburtsort());
            model.addAttribute("Wohnungort", arbeitnehmer.getWohnungort());
            arbeitnehmer.getSchulische_Ausbildung().replaceAll(";", "</br>");
            model.addAttribute("Schulische_Ausbildung", arbeitnehmer.getSchulische_Ausbildung());
            model.addAttribute("Berufliche_Ausbildung", arbeitnehmer.getBerufliche_Ausbildung());
            model.addAttribute("Studium", arbeitnehmer.getStudium());
            model.addAttribute("Abteilung_id", arbeitnehmer.getAbteilung_id());
        return "edit-student";
    }

    @RequestMapping("/run")
    public String Edit(Arbeitnehmer arbeitnehmer,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) throws JSONException, IOException {

        int id = (int) httpServletRequest.getSession().getAttribute("getid");
        try {
            int editById = arbeitnehmerEditService.EditById(arbeitnehmer, id);
            System.out.println(editById);
        } catch (Exception e) {
            e.printStackTrace();
            Object name1 = httpServletRequest.getSession().getAttribute("name");
            Object abteilung = httpServletRequest.getSession().getAttribute("abteilung");
            Object bilder = httpServletRequest.getSession().getAttribute("bilder");
            model.addAttribute("getname",name1);
            model.addAttribute("getabteilung",abteilung);
            model.addAttribute("bilder",bilder);
            model.addAttribute("error",e.getMessage());
            model.addAttribute("getid",id);
            return "error-404";
        }

        return "forward:/arbeitnehmerlist";
    }
}
