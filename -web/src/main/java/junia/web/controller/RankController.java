package junia.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RankController implements RestController {

    private static final Logger logger =  LoggerFactory.getLogger(RankController.class);

    public RankController() {
        logger.info("Initialisation RankController");
    }

    @RequestMapping(value = "/rank", method = RequestMethod.GET)
    public String getRankPage(ModelMap modelMap){
        modelMap.addAttribute("teachers",TeacherController.getInstance().getList());
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            modelMap.put("role", user.getAuthorities().toString());
        }
        return "rank";
    }

}
