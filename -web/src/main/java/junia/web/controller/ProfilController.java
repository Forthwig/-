package junia.web.controller;

import junia.lab.core.service.ReviewService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ProfilController implements RestController {

    private ReviewService reviewService;

    public ProfilController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @RequestMapping(value = "student/profil/{studentId}", method = RequestMethod.GET)
    public String getStudentPage(@PathVariable("studentId") long studentId, ModelMap modelMap){
        //TODO renvoie la liste de ces commentaire.
        modelMap.put("nb",reviewService.getReviewByStudent(studentId).size());
        return "profil";
    }

    @RequestMapping(value = "teacher/profil/{teacherId}", method = RequestMethod.GET)
    public String getTeacherPage(@PathVariable("teacherId") long teacherId, ModelMap modelMap){
        //TODO renvoie la liste des commentaire de ces lessons.
        modelMap.put("nb",reviewService.getReviewByLessonByTeacher(teacherId).size());
        return "profil";
    }

}