package junia.lab.core.service;

import junia.lab.core.dao.TeacherDAO;
import junia.lab.core.entity.Teacher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TeacherService {

    private TeacherDAO teacherDAO;

    public TeacherService(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public Teacher getById(long teacherId) {
        return teacherDAO.getOne(teacherId);
    }

    public List<Teacher> findAll() {
        return teacherDAO.findAll();
    }

    public void save(Teacher teacher){
        teacherDAO.save(teacher);
    }

    public void deleteTeacherById(long teacherId){
        teacherDAO.deleteById(teacherId);
    }


    public Teacher getByEmail(String email) {
        return teacherDAO.getOneByEmail(email);
    }
}
