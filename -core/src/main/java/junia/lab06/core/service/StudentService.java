package junia.lab06.core.service;

import junia.lab06.core.dao.StudentDAO;
import junia.lab06.core.entity.Student;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

}
