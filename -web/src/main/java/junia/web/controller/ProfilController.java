package junia.web.controller;

import junia.lab.core.entity.Promo;
import junia.lab.core.entity.Review;
import junia.lab.core.entity.Student;
import junia.lab.core.entity.Teacher;
import junia.lab.core.service.ReviewService;
import junia.lab.core.service.StudentService;
import junia.lab.core.service.TeacherService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class ProfilController implements RestController {

    private ReviewService reviewService;
    private StudentService studentService;
    private TeacherService teacherService;

    public ProfilController(ReviewService reviewService, StudentService studentService, TeacherService teacherService) {
        this.reviewService = reviewService;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @RequestMapping(value = "student", method = RequestMethod.GET)
    public String getStudentPage(@RequestParam(value = "error", required = false) String error, ModelMap modelMap){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Student student = studentService.getByEmail(user.getUsername());
        modelMap.put("reviews",reviewService.getReviewByStudent(student.getId()));
        modelMap.addAttribute("student", student);
        modelMap.addAttribute("teachers",teacherService.findAll());
        modelMap.addAttribute("promos", Promo.values());
        String errorMessage = "";
        if(error != null)
            errorMessage = "error dans le titre ou dans le text";
        modelMap.addAttribute("errorMessage", errorMessage);
        return "profil";
    }

    @RequestMapping(value = "teacher", method = RequestMethod.GET)
    public String getTeacherPage( ModelMap modelMap){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Teacher teacher = teacherService.getByEmail(user.getUsername());
        modelMap.addAttribute("mail", teacher.getEmail());//
        return "profil";
    }

    @RequestMapping(value = "student/update", method = RequestMethod.GET)
    public String setSurnomAndPromoPage(String surnom,String promo,String image,ModelMap modelMap){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Student student = studentService.getByEmail(user.getUsername());
        student.setSurnom(surnom);
        student.setPromo(Promo.valueOf(promo));
        student.setImage(image);
        this.studentService.save(student);
        return "redirect:profil";
    }

    @RequestMapping(value = "student/add", method = RequestMethod.POST)
    public String addReview(String title,String emailteacher,String text,ModelMap modelMap){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Student student = studentService.getByEmail(user.getUsername());
        System.out.println(student.getSurnom());
        System.out.println(title);
        System.out.println(teacherService.getByEmail(emailteacher));
        System.out.println(text);
        System.out.println(new Date());
        if(title != null && emailteacher != null && text != null){
            Review review = new Review();
            review.setText(text);
            review.setTitle(title);
            review.setStudent(student);
            review.setTeacher(teacherService.getByEmail(emailteacher));
            review.setDateOfReview(new Date());
            this.reviewService.save(review);
            modelMap.remove("error");
        }
        else{
            modelMap.addAttribute("error", "true");
        }
        return "redirect:../student";
    }

}