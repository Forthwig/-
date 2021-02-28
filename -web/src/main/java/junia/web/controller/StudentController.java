package junia.web.controller;

import junia.lab.core.entity.Student;
import junia.lab.core.service.StudentService;
import junia.lab.core.service.TeacherService;
import junia.web.dto.StudentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@Path("/student")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentController implements RestController {

    private static StudentController instance;

    public static StudentController getInstance(){
        return instance;
    }

    private StudentService studentService;

    private static final Logger logger =  LoggerFactory.getLogger(TeacherService.class);

    public StudentController(StudentService reviewService) {
        this.studentService = reviewService;
        instance = this;
    }

    /** API **/

    @POST
    @Path("/add")
    public void save(Student student){
        studentService.save(student);
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

    public Student getStudentByName(String mail){
        return studentService.getByEmail(mail);
    }

}
