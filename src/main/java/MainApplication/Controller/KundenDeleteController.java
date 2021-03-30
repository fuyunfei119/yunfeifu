package MainApplication.Controller;

import MainApplication.Service.KundenDeleteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class KundenDeleteController {

    @Resource
    private KundenDeleteService kundenDeleteService;

    @RequestMapping("/KundenDelete")
    public String KundenDelete(Integer id) throws InterruptedException {
        int kundendelete = kundenDeleteService.Kundendelete(id);
        return "forward:/Kundenlist";
    }
}
