package junia.web.controller;

import junia.lab.core.entity.Teacher;
import junia.lab.core.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import junia.web.dto.TeacherDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@Path("/teacher")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherController implements RestController {

    private TeacherService teacherService;

    private static final Logger logger =  LoggerFactory.getLogger(TeacherService.class);

    /**
     *if use velocity
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String getListOfCompanies(ModelMap modelMap){
        modelMap.put("teachers",this.teacherService.findAll());
        return  "TeacherList";
    }
    **/
    public TeacherController(TeacherService reviewService) {
        this.teacherService = reviewService;
    }

    @POST
    @Path("")
    public void saveReview(Teacher review){
        teacherService.save(review);
    }

    @DELETE
    @Path("/{reviewId}")
    public void deleteReviewById(@PathParam("reviewId") long reviewId){
        teacherService.deleteTeacherById(reviewId);
    }

    @GET
    @Path("")
    public Map<Long,String> listTeacher(){
        return teacherService.findAll().stream().collect(Collectors.toMap(Teacher::getId, Teacher::getFirstName));
    }

    @GET
    @Path("/{teacherId}")
    public TeacherDTO getTeacherById(@PathParam("teacherId") long teacherId){
        Teacher teacher = teacherService.getById(teacherId);
        TeacherDTO result = new TeacherDTO();
        result.setId(teacher.getId());
        result.setFirstName(teacher.getFirstName());
        //...
        return result;

    }


}
