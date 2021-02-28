package junia.web.controller;

import junia.lab.core.service.LessonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class RankController implements RestController{

    private static final Logger logger =  LoggerFactory.getLogger(RankController.class);

    public RankController() {
    }

    @RequestMapping(value = "/rank", method = RequestMethod.GET)
    public String getRankPage(ModelMap modelMap){
        System.out.println("ttttttttttt");
        return "rank";
    }

}
