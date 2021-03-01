package junia.web.controller;

import junia.lab.core.entity.Promo;
import junia.lab.core.entity.Review;
import junia.lab.core.entity.Student;
import junia.lab.core.entity.Teacher;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class ProfilController implements RestController {



    public ProfilController() {
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String getStudentPage(@RequestParam(value = "error", required = false) String error, ModelMap modelMap){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        modelMap.addAttribute("student", StudentController.getInstance().getStudentByName(user.getUsername()));
        modelMap.addAttribute("teachers",TeacherController.getInstance().getList());
        modelMap.addAttribute("promos", Promo.values());
        String errorMessage = "";
        if(error != null)
            errorMessage = "error dans le titre ou dans le text";
        modelMap.addAttribute("errorMessage", errorMessage);
        return "profil";
    }

    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public String getTeacherPage( ModelMap modelMap){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Teacher teacher = TeacherController.getInstance().getTeacherByMail(user.getUsername());
        modelMap.addAttribute("mail", teacher.getEmail());//
        return "profil";
    }

    @RequestMapping(value = "/student/update", method = RequestMethod.POST)
    public String setSurnomAndPromoPage(String surnom,String promo,String image,ModelMap modelMap){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Student student = StudentController.getInstance().getStudentByName(user.getUsername());
        if(!surnom.equals(""))
            student.setSurnom(surnom);
        if(!promo.equals(""))
            student.setPromo(Promo.valueOf(promo));
        if(image != null)
            student.setImage(image);
        StudentController.getInstance().save(student);
        return "redirect:../student";
    }

    @RequestMapping(value = "/student/add", method = RequestMethod.POST)
    public String addReview(String title,String emailteacher,String text,ModelMap modelMap){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Student student = StudentController.getInstance().getStudentByName(user.getUsername());
        System.out.println(student.getSurnom());
        System.out.println(title);
        System.out.println(TeacherController.getInstance().getTeacherByMail(emailteacher));
        System.out.println(text);
        System.out.println(new Date());
        if(title != null && emailteacher != null && text != null){
            Review review = new Review();
            review.setText(text);
            review.setTitle(title);
            review.setStudent(student);
            review.setTeacher(TeacherController.getInstance().getTeacherByMail(emailteacher));
            review.setDateOfReview(new Date());
            ReviewController.getInstance().saveReview(review);
            modelMap.remove("error");
        }
        else{
            modelMap.addAttribute("error", "true");
        }
        return "redirect:../student";
    }

}