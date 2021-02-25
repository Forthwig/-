package junia.web.controller;

import junia.lab.core.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController implements RestController {

    private ReviewService reviewService;

    public HomeController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHomePage(ModelMap modelMap){
        return "index";
    }
}
