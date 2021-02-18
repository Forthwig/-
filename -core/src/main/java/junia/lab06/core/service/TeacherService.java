package junia.lab06.core.service;

import junia.lab06.core.dao.TeacherDAO;
import junia.lab06.core.entity.Teacher;

import java.util.List;

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


}
