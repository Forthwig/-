package junia.web.controller;

import junia.lab.core.entity.Teacher;
import junia.lab.core.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import junia.web.dto.TeacherDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@Path("/teacher")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherController implements RestController {

    private static TeacherController instance;
    private TeacherService teacherService;

    public static TeacherController getInstance(){
        return instance;
    }

    private static final Logger logger =  LoggerFactory.getLogger(TeacherController.class);

    private TeacherController(TeacherService reviewService) {
        logger.info("Initialisation TeacherController");
        this.teacherService = reviewService;
        instance = this;
    }

    /** Web **/

    public List<Teacher> getList(){
        return teacherService.findAll();
    }

    public Boolean contains(String mail){
        return teacherService.findAll().stream().anyMatch(teacher -> teacher.getEmail().contains(mail));
    }

    public Teacher getTeacherByMail(String mail){
        return teacherService.getByEmail(mail);
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

}
