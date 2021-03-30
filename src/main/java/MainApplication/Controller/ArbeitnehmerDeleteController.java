package MainApplication.Controller;

import MainApplication.Bean.Arbeitnehmer;
import MainApplication.Dao.LoginDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.File;

@Controller
public class ArbeitnehmerDeleteController {

    @Resource
    private LoginDao loginDao;


    @RequestMapping("/arbeitnehmerDelete")
    public String arbeitnehmerDelete(Integer id) throws InterruptedException {

        Arbeitnehmer arbeiternehmer = loginDao.findById(id);

        File file = new File("D:\\IdeaProjects\\CRM\\src\\main\\resources\\static\\assets\\img\\profiles");
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.getName().contains(arbeiternehmer.getName()+".jpg")){
                f.delete();
            }
        }

        Thread.sleep(1000);
        int delete = loginDao.ArbeitnehmerDelete(id);
        return "forward:/arbeitnehmerlist";
    }
}
