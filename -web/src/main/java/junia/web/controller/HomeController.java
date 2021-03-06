package junia.web.controller;

import junia.lab.core.service.LessonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.Path;

@Controller
public class HomeController implements RestController {

    private static final Logger logger =  LoggerFactory.getLogger(LessonService.class);

    public HomeController() {
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHomePage(ModelMap modelMap){
        modelMap.addAttribute("lessons",LessonController.getInstance().getList());
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            modelMap.put("role", user.getAuthorities().toString());
        }
        else{
            modelMap.remove("role");
            modelMap.remove("mail");
        }
        return "index";
    }
}
