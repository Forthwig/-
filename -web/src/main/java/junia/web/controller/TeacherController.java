package junia.web.controller;

import junia.lab.core.entity.Teacher;
import junia.lab.core.service.TeacherService;
import junia.web.controller.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import junia.web.dto.TeacherDTO;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@Path("/teacher")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherController implements RestController {

    private static TeacherController instance;

    private TeacherService teacherService;

    private static final Logger logger =  LoggerFactory.getLogger(TeacherService.class);

    private TeacherController(TeacherService reviewService) {
        this.teacherService = reviewService;
        instance = this;
    }

    /** API **/

    @POST
    @Path("/add")
    public void save(Teacher teacher){
        teacherService.save(teacher);
    }

    @DELETE
    @Path("/remove/{teacherId}")
    public void deleteReviewById(@PathParam("teacherId") long reviewId){
        teacherService.deleteTeacherById(reviewId);
    }

    @GET
    @Path("")
    public Map<Long,String> listTeacher(){
        return teacherService.findAll().stream().collect(Collectors.toMap(Teacher::getId, Teacher::getEmail));
    }

    @GET
    @Path("/{teacherId}")
    public TeacherDTO getTeacherById(@PathParam("teacherId") long teacherId){
        Teacher teacher = teacherService.getById(teacherId);
        TeacherDTO result = new TeacherDTO();
        result.setId(teacher.getId());
        result.setEmail(teacher.getEmail());
        result.setPassword(teacher.getPassword());
        return result;
    }

    public Boolean contais(String mail){
        return teacherService.findAll().stream().anyMatch(teacher -> teacher.getEmail().contains(mail));
    }

    public Teacher getTeacherByMail(String mail){
        return teacherService.getByEmail(mail);
    }

    public static TeacherController getInstance(){
        return instance;
    }


}
