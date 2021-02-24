package junia.web.controller;

import junia.lab.core.entity.Lesson;
import junia.lab.core.service.LessonService;
import junia.web.dto.LessonDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@Path("/lesson") //TODO redirect in .vm
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LessonController implements RestController{

    private LessonService lessonService;

    private static final Logger logger =  LoggerFactory.getLogger(LessonService.class);

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    /** WEB ** /
     *
     * TODO importé le TP07 avec les slide
     */


    /** API **/

    @GET
    @Path("")
    public Map<Long,String> listBooks(){
        return lessonService.findAll().stream().collect(Collectors.toMap(Lesson::getId, Lesson::getTitle));
    }

    @GET
    @Path("/{lessonId}")
    public LessonDTO getBookById(@PathVariable("lessonId") long lessonId){
        Lesson lesson = lessonService.findById(lessonId);
        LessonDTO result = new LessonDTO();
        result.setLanguage(lesson.getLanguage());
        result.setTeachers(lesson.getTeachers());
        result.setStudents(lesson.getStudents());
        result.setTitle(lesson.getTitle());
        return result;
    }

}
