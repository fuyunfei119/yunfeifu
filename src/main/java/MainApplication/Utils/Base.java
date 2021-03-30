package MainApplication.Utils;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

public class Base {

    @ModelAttribute
    public void PreHandler(HttpServletRequest httpServletRequest){
        httpServletRequest.setAttribute("ctx",httpServletRequest.getContextPath());
    }
}
