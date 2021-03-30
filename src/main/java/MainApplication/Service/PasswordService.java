package MainApplication.Service;

import MainApplication.Dao.LoginDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED)
public class PasswordService {

    @Resource
    private LoginDao loginDao;

    public void passwordService(String OldPassword, String NewPassword, String ConfirmPassword, HttpServletRequest httpServletRequest) throws Exception {
        Object password = httpServletRequest.getSession().getAttribute("password");
        Object getname = httpServletRequest.getSession().getAttribute("name");
        if (StringUtils.isEmpty(getname)){
            throw new Exception("zu ändernede Userpassword exsiert nicht !");
        }else {
            if (StringUtils.isEmpty(OldPassword)){
                throw new Exception("old password könnte nicht leer sein !");
            }else {
                if (!(OldPassword.equals(password))) {
                    throw new Exception("falsch old password ! versuch reneut noch mal !");
                }else {
                    if (StringUtils.isEmpty(NewPassword)){
                        throw new Exception("new Password könnte nicht leer sein !");
                    }else if (NewPassword.equals(OldPassword)){
                        throw new Exception("New password dürft nicht gleich wie Oldpassowrd !");
                    }else {
                        if (StringUtils.isEmpty(ConfirmPassword)){
                            throw new Exception("ConfirmPassword ist Leer !");
                        }else {
                            if (NewPassword.equals(ConfirmPassword)){
                                loginDao.passwordandern(NewPassword,getname.toString());
                                throw new Exception("Erfolgreich password Änderung");
                            }else {
                                throw new Exception("ConfirmPassword nicht gleich wie New Password !");
                            }
                        }
                    }
                }
            }
        }

    }
}
