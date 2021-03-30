package MainApplication.Service;

import MainApplication.Bean.Arbeitnehmer;
import MainApplication.Dao.LoginDao;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.File;

@Service
public class ArbeitnehmerEditService {

    @Resource
    private LoginDao loginDao;

    public Arbeitnehmer NativeInfo(Integer id){
        Arbeitnehmer arbeitnehmer = loginDao.findById(id);
        return arbeitnehmer;
    }

    public int EditById(Arbeitnehmer arbeitnehmer, int id) throws Exception {
        if (arbeitnehmer.getGeschlechte().equals("Geschlechte Auswählen")){
            throw new Exception("Bitte wählen Sie ihre Geschlechte!!");
        }
        if (arbeitnehmer.getUploadfile().isEmpty()){
            throw new Exception("Sie haben noch kein Bilder hochgeladet!");
        }else {
            arbeitnehmer.setBilder("assets/img/profiles/"+arbeitnehmer.getName()+".jpg");
            File file = new File("D:\\IdeaProjects\\CRM\\src\\main\\resources\\static\\assets\\img\\profiles");
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.getName().contains(arbeitnehmer.getName()+".jpg")){
                    boolean delete = f.delete();
                    if (delete){
                        System.out.println("删除成功");
                    }else {
                        System.out.println("删除失败");
                    }
                }
            }
            Thread.sleep(1000);
            arbeitnehmer.getUploadfile().transferTo(new File("D:\\IdeaProjects\\CRM\\src\\main\\resources\\static\\assets\\img\\profiles\\"+arbeitnehmer.getName()+".jpg"));
        }

        int arbeitnehmerEdit = loginDao.ArbeitnehmerEditById(arbeitnehmer,id);
        return arbeitnehmerEdit;
    }

    public int EditByName(Arbeitnehmer arbeitnehmer,String name){
        int arbeitnehmerEditByName = loginDao.ArbeitnehmerEditByName(arbeitnehmer, name);
        return arbeitnehmerEditByName;
    }
}
