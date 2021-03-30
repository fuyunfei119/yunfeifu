package MainApplication.Service;

import MainApplication.Bean.Arbeitnehmer;
import MainApplication.Dao.LoginDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

@Service
public class ArbeitnehmerAddService {

    @Resource
    private LoginDao loginDao;

    public int arbeitnehmeradd(Arbeitnehmer arbeitnehmer,String name) throws IOException {
        String substring = arbeitnehmer.getUploadfile().getOriginalFilename().substring(0, arbeitnehmer.getUploadfile().getOriginalFilename().length() - 4);
        String replace = arbeitnehmer.getUploadfile().getOriginalFilename().replace(substring,name);
        arbeitnehmer.setBilder("assets/img/profiles/"+replace);
        arbeitnehmer.getUploadfile().transferTo(new File("D:\\IdeaProjects\\CRM\\src\\main\\resources\\static\\assets\\img\\profiles\\"+replace));
        int add = loginDao.ArbeitnehmerAdd(arbeitnehmer);
        return add;
    }
}
