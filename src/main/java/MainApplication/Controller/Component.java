package MainApplication.Controller;

import MainApplication.Bean.Abteilung;
import MainApplication.Bean.Arbeitnehmer;
import MainApplication.Dao.AbteilungDao;
import MainApplication.Dao.ComponentsDao;
import MainApplication.Dao.LoginDao;
import MainApplication.Service.ArbeitnehmerService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.model.IModel;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class Component {


    @Resource
    private ComponentsDao componentsDao;
    @Resource
    private AbteilungDao abteilungDao;
    @Resource
    private ArbeitnehmerService arbeitnehmerService;

    @RequestMapping("/siderbar")
    @ResponseBody
    public String siderbar(Model model) throws JSONException {
        List<Abteilung> abteilungs = abteilungDao.abteilungList();
        model.addAttribute("Abteilunglist",abteilungs);
        List<Arbeitnehmer> arbeitnehmerList = arbeitnehmerService.findallpersoninformations();
        model.addAttribute("Names",arbeitnehmerList);
        System.out.println(arbeitnehmerList);
        return null;
    }
}
