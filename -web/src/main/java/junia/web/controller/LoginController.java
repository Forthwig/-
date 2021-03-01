package junia.web.controller;

import junia.lab.core.entity.Student;
import junia.lab.core.entity.Teacher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController implements RestController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            ModelMap modelMap) {
        String errorMessage = "";
        if(error != null)
            errorMessage = "Username or Password is incorrect !!";
        if(logout != null)
            errorMessage = "You have been successfully logged out !!";
        modelMap.addAttribute("errorMessage", errorMessage);
        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/login/add", method = RequestMethod.POST)
    public String addReview(String username,String password,ModelMap modelMap){
        if(username.isEmpty()) {
            modelMap.addAttribute("error", "true");
            return "redirect:/";
        }

        if(TeacherController.getInstance().contains(username)){
            modelMap.addAttribute("error", "true");
            return "redirect:/";
        }

        if(username.contains("@isen.yncrea.fr")){
            Student student = new Student();
            student.setEmail(username);
            student.setPassword(password);
            student.setEnable(1);
            student.setRole("ROLE_STUDENT");
            StudentController.getInstance().save(student);
            return "redirect:../student";
        }
        else if(username.contains("@yncrea.fr")){
            Teacher teacher = new Teacher();
            teacher.setEmail(username);
            teacher.setPassword(password);
            teacher.setEnable(1);
            teacher.setRole("ROLE_TEACHER");
            TeacherController.getInstance().save(teacher);
            return "redirect:../teacher";
        }

        modelMap.addAttribute("error", "true");
        return "redirect:../student";
    }

}
