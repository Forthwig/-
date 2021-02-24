package junia.lab.core.service;

import junia.lab.core.dao.StudentDAO;
import junia.lab.core.entity.Student;
import junia.lab.core.entity.Teacher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class StudentService {

    private StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void save(Student student){
        studentDAO.save(student);
    }

    public void deleteStudent(long studentId){
        studentDAO.deleteById(studentId);
    }

    public Student getById(long studentID) {
        return studentDAO.getOne(studentID);
    }


    public List<Student> findAll() {
        return studentDAO.findAll();
    }
}
