package junia.web.controller;

import junia.lab.core.service.ReviewService;
import junia.lab.core.service.StudentService;
import junia.lab.core.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "student/{studentId}", method = RequestMethod.GET)
    public String getStudentPage(@PathVariable("studentId") long studentId, ModelMap modelMap){
        //TODO renvoie la liste de ces commentaire.
        modelMap.put("nb",reviewService.getReviewByStudent(studentId).size());
        modelMap.put("email",studentService.getById(studentId).getEmail());
        return "profil";
    }

    @RequestMapping(value = "teacher/{teacherId}", method = RequestMethod.GET)
    public String getTeacherPage(@PathVariable("teacherId") long teacherId, ModelMap modelMap){
        //TODO renvoie la liste des commentaire de ces lessons.
        modelMap.put("nb",reviewService.getReviewByLessonByTeacher(teacherId).size());
        modelMap.put("email",teacherService.getById(teacherId).getEmail());
        return "profil";
    }

}