package MainApplication.Controller;

import MainApplication.Bean.Abteilung;
import MainApplication.Bean.Anforderung;
import MainApplication.Bean.Arbeitnehmer;
import MainApplication.Dao.LoginDao;
import MainApplication.Service.AbteilungfindService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class ArbeitnehmerViewController {

    @Resource
    private LoginDao loginDao;
    @Resource
    private AbteilungfindService abteilungfindService;

    @RequestMapping("/arbeitnehmerView")
    public String arbeitnehmerView(HttpServletRequest httpServletRequest, Model model, String nameid, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        Object nam = httpServletRequest.getSession().getAttribute("name");
        Object abteilun = httpServletRequest.getSession().getAttribute("abteilung");
        Object bilde = httpServletRequest.getSession().getAttribute("bilder");
        model.addAttribute("name",nam);
        model.addAttribute("abteilung",abteilun);
        model.addAttribute("bilde",bilde);
        if (nameid!=null) {

            Arbeitnehmer arbeitnehmer = loginDao.findbyName(nameid);
            Abteilung abteilung = abteilungfindService.findAbteilung(arbeitnehmer.getAbteilung_id(), arbeitnehmer.getName());
            model.addAttribute("getname", arbeitnehmer.getName());
            model.addAttribute("getabteilung", abteilung.getAbteilung_name());
            model.addAttribute("bilder", arbeitnehmer.getBilder());
            String PersonlicheBeschreibung = "hallo ich bin" + arbeitnehmer.getName() + abteilung.getAbteilung_beschreibung();
            model.addAttribute("beschreibung", PersonlicheBeschreibung);
            model.addAttribute("telefonnummer", arbeitnehmer.getTelefonnummber());
            model.addAttribute("mail", arbeitnehmer.getMail());
            model.addAttribute("geschlechte", arbeitnehmer.getGeschlechte());
            model.addAttribute("geburtsdatum", arbeitnehmer.getGeburtsdatum());
            model.addAttribute("geburtsort", arbeitnehmer.getGeburtsort());
            model.addAttribute("wohnungsort", arbeitnehmer.getWohnungort());
            arbeitnehmer.getSchulische_Ausbildung().replaceAll(";", "</br>");
            model.addAttribute("schule", arbeitnehmer.getSchulische_Ausbildung());
            model.addAttribute("ausbildung", arbeitnehmer.getBerufliche_Ausbildung());
            model.addAttribute("studium", arbeitnehmer.getStudium());

            String id = String.valueOf(arbeitnehmer.getId());
            List<Anforderung> anforderungs = abteilungfindService.anforderungs(id);
            System.out.println(anforderungs);
            model.addAttribute("AnforderungsList",anforderungs);

        }
        else {
        Object name = httpServletRequest.getSession().getAttribute("name");
        httpServletRequest.getSession().getAttribute("");
        Object abteilung = httpServletRequest.getSession().getAttribute("abteilung");
        Object bilder = httpServletRequest.getSession().getAttribute("bilder");
        Object telefonnummber = httpServletRequest.getSession().getAttribute("telefonnummber");
        Object mail = httpServletRequest.getSession().getAttribute("mail");
        Object geschlechte = httpServletRequest.getSession().getAttribute("geschlechte");
        Object geburtsdatum = httpServletRequest.getSession().getAttribute("geburtsdatum");
        Object abteilungbeschreibung = httpServletRequest.getSession().getAttribute("abteilungbeschreibung");
        Object PersonlicheBeschreibung = "hallo ich bin"+name+','+abteilungbeschreibung;
        Object geburtsort = httpServletRequest.getSession().getAttribute("geburtsort");
        Object wohnungsort = httpServletRequest.getSession().getAttribute("wohnungsort");
        Object schule = httpServletRequest.getSession().getAttribute("schule");
        String schuleehance = schule.toString().replaceAll(";", "<br/>");
        Object ausbildung = httpServletRequest.getSession().getAttribute("ausbildung");
        Object studium = httpServletRequest.getSession().getAttribute("studium");

        model.addAttribute("getname",name);
        model.addAttribute("getabteilung",abteilung);
        model.addAttribute("bilder",bilder);
        model.addAttribute("beschreibung",PersonlicheBeschreibung);
        model.addAttribute("telefonnummer",telefonnummber);
        model.addAttribute("mail",mail);
        model.addAttribute("geschlechte",geschlechte);
        model.addAttribute("geburtsdatum",geburtsdatum);
        model.addAttribute("geburtsort",geburtsort);
        model.addAttribute("wohnungsort",wohnungsort);
        model.addAttribute("schule",schuleehance);
        model.addAttribute("ausbildung",ausbildung);
        model.addAttribute("studium",studium);

           /* List<Anforderung> anforderungs = abteilungfindService.anforderungs(nameid);
            System.out.println(anforderungs);
            model.addAttribute("AnforderungsList",anforderungs);*/

        }
        return "student-details";
    }

}
