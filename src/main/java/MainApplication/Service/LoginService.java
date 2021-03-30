package MainApplication.Service;

import MainApplication.Bean.Arbeitnehmer;
import MainApplication.Dao.LoginDao;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class LoginService {

    @Resource
    private LoginDao loginDao;

    public Arbeitnehmer Login(String name,String password) throws Exception {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)){
            throw new Exception("username und password könnten nicht leer sein !");
        }else {
            Arbeitnehmer arbeitnehmer = loginDao.findbyName(name);
            if (arbeitnehmer != null){
                if (password.equals(arbeitnehmer.getPassword())){
                    return arbeitnehmer;
                }else {
                    throw new Exception("falsche Password!");
                }
            }else {
                throw new Exception("Sie haben noch kein Account bei uns! bitte Regiestrieren erst!");
            }
        }
    }
}
