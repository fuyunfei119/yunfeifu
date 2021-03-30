package MainApplication.Controller;

import MainApplication.Service.PasswordService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class PasswordController {

    @Resource
    private PasswordService passwordService;


    @RequestMapping("/password")
    public void passwordaendern(String OldPassword, String NewPassword, String ConfirmPassword, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, JSONException {
        try {
            passwordService.passwordService(OldPassword,NewPassword,ConfirmPassword,httpServletRequest);
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("errormessage",e.getMessage());
            httpServletResponse.setCharacterEncoding("utf-8");
            httpServletResponse.getWriter().append(jsonObject.toString());
        }
    }
}
