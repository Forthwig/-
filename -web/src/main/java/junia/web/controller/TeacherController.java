package junia.web.controller;

import junia.lab.core.entity.Teacher;
import junia.lab.core.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import junia.web.dto.TeacherDTO;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@Path("/teacher") //TODO redirect in .vm
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherController implements RestController {

    private TeacherService teacherService;

    private static final Logger logger =  LoggerFactory.getLogger(TeacherService.class);

    public TeacherController(TeacherService reviewService) {
        this.teacherService = reviewService;
    }

    /** WEB **/

    @GET
    @RequestMapping("/{teacherId}")
    public String getTeacherById(@PathVariable("teacherId") long teacherId, ModelMap modelMap){
        Teacher teacher = teacherService.getById(teacherId);
        modelMap.put("email",teacher.getEmail());
        modelMap.put("lesson",teacher.getLessons());
        modelMap.put("id",teacher.getId());
        return "profil";
    }

    /** API **/

    @POST
    @Path("/add")
    public void saveReview(Teacher review){
        teacherService.save(review);
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
