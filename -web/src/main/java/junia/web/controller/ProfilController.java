package junia.web.controller;

import junia.lab.core.entity.Student;
import junia.lab.core.entity.Teacher;
import junia.lab.core.service.ReviewService;
import junia.lab.core.service.StudentService;
import junia.lab.core.service.TeacherService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        modelMap.put("nb",reviewService.getReviewByStudent(student.getId()).size());
        modelMap.addAttribute("email", student.getEmail());//
        return "profil";
    }

    @RequestMapping(value = "teacher", method = RequestMethod.GET)
    public String getTeacherPage( ModelMap modelMap){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Teacher teacher = teacherService.getByEmail(user.getUsername());
        modelMap.put("nb",reviewService.getReviewByStudent(teacher.getId()).size());
        modelMap.addAttribute("email", teacher.getEmail());//
        return "profil";
    }

}