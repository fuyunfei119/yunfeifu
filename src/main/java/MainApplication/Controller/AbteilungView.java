package MainApplication.Controller;

import MainApplication.Bean.Abteilung;
import MainApplication.Bean.Arbeitnehmer;
import MainApplication.Dao.AbteilungDao;
import MainApplication.Service.ArbeitnehmerService;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.naming.EjbRef;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
import org.json.JSONStringer;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AbteilungView {

    @Resource
    private AbteilungDao abteilungDao;
    @Resource
    private ArbeitnehmerService arbeitnehmerService;

    @RequestMapping("/AbteilungView")
    public String AbteilungView(HttpServletRequest httpServletRequest, Model model, HttpServletResponse httpServletResponse) throws JSONException, IOException, org.json.JSONException {

        InboxController.UserMenueInfo(httpServletRequest,model);

        List<Abteilung> abteilungs = abteilungDao.abteilungList();

        List<Arbeitnehmer> arbeitnehmerList = arbeitnehmerService.findallpersoninformations();

        Map<String, Double> maps = new HashMap<>();
        JSONArray array = new JSONArray();

        Double sum =abteilungDao.sum();
        for (int i = 0; i < abteilungs.size(); i++) {
            Double zahl = 0.0;
            for (int j = 0; j < arbeitnehmerList.size(); j++) {
                if (abteilungs.get(i).getAbteilung_id()==arbeitnehmerList.get(j).getAbteilung_id()){
                    zahl++;
                }
                maps.put(abteilungs.get(i).getAbteilung_name(),zahl);
            }

            Double prozent = zahl/sum;
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name",abteilungs.get(i).getAbteilung_name());
            jsonObject.put("value",prozent*100);
            array.put(jsonObject);
        }
        System.out.println(array);
        model.addAttribute("maps",maps);
        httpServletRequest.getSession().setAttribute("jsarray",array);
        return "department-details";
    }


    @RequestMapping("/Echarts")
    @ResponseBody
    public String echarts(HttpServletRequest httpServletRequest,Model model) throws org.json.JSONException, JsonProcessingException {
        Object jsarray = httpServletRequest.getSession().getAttribute("jsarray");
        //String replaceAll = jsarray.toString().replaceAll("\"(\\w+)\"(\\s*:\\s*)", "$1$2");
        //System.out.println(replaceAll);
        return jsarray.toString();
    }
}
