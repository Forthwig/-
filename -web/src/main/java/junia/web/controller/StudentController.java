package junia.web.controller;

import junia.lab.core.entity.Student;
import junia.lab.core.entity.Teacher;
import junia.lab.core.service.StudentService;
import junia.lab.core.service.TeacherService;
import junia.web.dto.StudentDTO;
import junia.web.dto.TeacherDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@Path("/student") //TODO redirect in .vm
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentController implements RestController {

    private StudentService studentService;

    private static final Logger logger =  LoggerFactory.getLogger(TeacherService.class);

    public StudentController(StudentService reviewService) {
        this.studentService = reviewService;
    }

    /** WEB **/

    @GET
    @RequestMapping("/{studenId}")
    public String getTeacherById(@PathVariable("studenId") long teacherId, ModelMap modelMap){
        Student student = studentService.getById(teacherId);
        modelMap.put("email",student.getEmail());
        modelMap.put("id",student.getId());
        return "profil";
    }

    /** API **/

    @POST
    @Path("/add")
    public void saveReview(Student review){
        studentService.save(review);
    }

    @DELETE
    @Path("/remove/{teacherId}")
    public void deleteReviewById(@PathParam("teacherId") long reviewId){
        studentService.deleteStudent(reviewId);
    }

    @GET
    @Path("")
    public Map<Long,String> listTeacher(){
        return studentService.findAll().stream().collect(Collectors.toMap(Student::getId, Student::getEmail));
    }

    @GET
    @Path("/{teacherId}")
    public StudentDTO getTeacherById(@PathParam("teacherId") long teacherId){
        Student student = studentService.getById(teacherId);
        StudentDTO result = new StudentDTO();
        result.setId(student.getId());
        result.setEmail(student.getEmail());
        result.setPassword(student.getPassword());
        return result;

    }
}
