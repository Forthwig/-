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
    public String getStudentPage( ModelMap modelMap){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Student student = studentService.getByEmail(user.getUsername());
        modelMap.put("reviews",reviewService.getReviewByStudent(student.getId()));
        modelMap.addAttribute("student", student);
        System.out.println(student.getSurnom());
        modelMap.addAttribute("teachers",teacherService.findAll());
        modelMap.addAttribute("promos", Promo.values());
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

    @RequestMapping(value = "student/add", method = RequestMethod.GET)
    public String addReview(String title,String emailteacher,String text,ModelMap modelMap){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Student student = studentService.getByEmail(user.getUsername());
        Review review = new Review();
        review.setText(text);
        review.setTitle(title);
        review.setStudent(student);
        review.setTeacher(teacherService.getByEmail(emailteacher));
        review.setDateOfReview(new Date());
        this.reviewService.save(review);
        return "redirect:profil";
    }

}