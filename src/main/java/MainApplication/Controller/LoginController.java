package MainApplication.Controller;

import MainApplication.Bean.Abteilung;
import MainApplication.Bean.Arbeitnehmer;
import MainApplication.Dao.AbteilungDao;
import MainApplication.Dao.AnforderungDao;
import MainApplication.Dao.KundenDao;
import MainApplication.Dao.LoginDao;
import MainApplication.Service.AbteilungfindService;
import MainApplication.Service.IndexEchartsService;
import MainApplication.Service.LoginService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
public class LoginController {

    @Resource
    private LoginService loginService;
    @Resource
    private AbteilungfindService abteilungfindService;
    @Resource
    private LoginDao loginDao;
    @Resource
    private KundenDao kundenDao;
    @Resource
    private AbteilungDao abteilungDao;
    @Resource
    private AnforderungDao anforderungDao;
    @Resource
    private IndexEchartsService indexEchartsService;

    @RequestMapping("/login")
    public void Login(Model model,String name, String password, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        try {
            Arbeitnehmer arbeitnehmer = loginService.Login(name, password);
            Abteilung abteilung = abteilungfindService.findAbteilung(arbeitnehmer.getAbteilung_id(),arbeitnehmer.getName());
            httpServletRequest.getSession().setAttribute("id",arbeitnehmer.getId());
            httpServletRequest.getSession().setAttribute("name",arbeitnehmer.getName());
            httpServletRequest.getSession().setAttribute("password",arbeitnehmer.getPassword());
            httpServletRequest.getSession().setAttribute("mail",arbeitnehmer.getMail());
            httpServletRequest.getSession().setAttribute("telefonnummber",arbeitnehmer.getTelefonnummber());
            httpServletRequest.getSession().setAttribute("eintragungszeit",arbeitnehmer.getEintragungszeit());
            httpServletRequest.getSession().setAttribute("geschlechte",arbeitnehmer.getGeschlechte());
            httpServletRequest.getSession().setAttribute("abteilung",abteilung.getAbteilung_name());
            httpServletRequest.getSession().setAttribute("geburtsort",arbeitnehmer.getGeburtsort());
            httpServletRequest.getSession().setAttribute("geburtsdatum",arbeitnehmer.getGeburtsdatum());
            httpServletRequest.getSession().setAttribute("wohnungsort",arbeitnehmer.getWohnungort());
            httpServletRequest.getSession().setAttribute("bilder",arbeitnehmer.getBilder());
            httpServletRequest.getSession().setAttribute("abteilungbeschreibung",abteilung.getAbteilung_beschreibung());
            httpServletRequest.getSession().setAttribute("schule",arbeitnehmer.getSchulische_Ausbildung());
            httpServletRequest.getSession().setAttribute("ausbildung",arbeitnehmer.getBerufliche_Ausbildung());
            httpServletRequest.getSession().setAttribute("studium",arbeitnehmer.getStudium());
            httpServletRequest.getSession().setAttribute("Abteilung_id",arbeitnehmer.getAbteilung_id());

            httpServletRequest.getRequestDispatcher("/index").forward(httpServletRequest,httpServletResponse);
        }catch (Exception e){
            JSONObject jsonObject = new JSONObject();
            httpServletResponse.setCharacterEncoding("utf-8");
            jsonObject.put("errormessage",e.getMessage());
            httpServletResponse.getWriter().append(jsonObject.toString());
        }
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest httpServletRequest,Model model,HttpServletResponse httpServletResponse) throws ServletException, IOException, JSONException {
        InboxController.UserMenueInfo(httpServletRequest, model);
        Integer sumofarbeitnehmer = loginDao.sum();
        model.addAttribute("sumofarbeitnehmer",sumofarbeitnehmer);
        Integer sumofkunden = kundenDao.sum();
        model.addAttribute("sumofkunden",sumofkunden);
        Integer sumofabteilung = abteilungDao.sumof();
        model.addAttribute("sumofabteilung",sumofabteilung);
        Integer sumofanforderung = anforderungDao.sum();
        model.addAttribute("sumofanforderung",sumofanforderung);

        return "index.html";
    }

    @RequestMapping("/indexcharts")
    @ResponseBody
    public String indexcharts() throws IOException, JSONException {

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        List<Map<String, Integer>> indexecharts = indexEchartsService.indexecharts();
        List<Integer> integerList = indexEchartsService.indexcharts2();

        int[] umsatzlist = new int[indexecharts.size()];
        for (int i = 0; i < integerList.size(); i++) {
            umsatzlist[i] = integerList.get(i);
        }

        String[] strings = new String[indexecharts.size()];
        int[] integers = new int[indexecharts.size()];
        for (int i = 0; i < indexecharts.size(); i++) {
            String[] strings1 = indexecharts.get(i).keySet().toArray(new String[indexecharts.get(i).size()]);
            strings[i] = "\""+strings1[0]+" Monate"+"\"";
            Integer[] integers1 = indexecharts.get(i).values().toArray(new Integer[indexecharts.get(i).size()]);
            integers[i] =integers1[0];
        }

        jsonObject.put("a", Arrays.toString(umsatzlist));
        jsonObject.put("b", Arrays.toString(integers));
        jsonObject.put("c", Arrays.toString(strings));

        List<String> chartsabteilung = indexEchartsService.chartsabteilung();
        String[] abteilungs = new String[chartsabteilung.size()];
        for (int i = 0; i < chartsabteilung.size(); i++) {
            abteilungs[i] = "\""+chartsabteilung.get(i)+"\"";
        }

        List<Double> chartsumsatz = indexEchartsService.chartsumsatz();
        double[] umsatzs = new double[chartsumsatz.size()];
        for (int i = 0; i < chartsumsatz.size(); i++) {
            umsatzs[i] = chartsumsatz.get(i);
        }


        jsonObject.put("d", Arrays.toString(abteilungs));
        jsonObject.put("e", Arrays.toString(umsatzs));
        jsonArray.put(jsonObject);
        return jsonArray.toString();
    }
}
