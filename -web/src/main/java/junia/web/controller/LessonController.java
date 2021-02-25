package junia.web.controller;

import junia.lab.core.entity.Lesson;
import junia.lab.core.entity.Review;
import junia.lab.core.entity.Student;
import junia.lab.core.entity.Teacher;
import junia.lab.core.service.LessonService;
import junia.web.controller.RestController;
import junia.web.dto.LessonDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@Path("/lesson")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LessonController implements RestController {

    private LessonService lessonService;

    private static final Logger logger =  LoggerFactory.getLogger(LessonService.class);

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GET
    @Path("")
    public Map<Long,String> listlessons(){
        return lessonService.findAll().stream().collect(Collectors.toMap(Lesson::getId, Lesson::getTitle));
    }

    @GET
    @Path("/{lessonId}")
    public LessonDTO getLessonById(@PathVariable("lessonId") long lessonId){
        Lesson lesson = lessonService.findById(lessonId);
        LessonDTO result = new LessonDTO();
        result.setLanguage(lesson.getLanguage().toString());
        result.setTeachers(lesson.getTeachers().stream().map(Teacher::toString).collect(Collectors.toList()));
        result.setStudents(lesson.getStudents().stream().map(Student::toString).collect(Collectors.toList()));
        result.setReviews(lesson.getReviews());
        result.setTitle(lesson.getTitle());
        return result;
    }

}
