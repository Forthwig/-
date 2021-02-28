package junia.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        return "rank";
    }

}
