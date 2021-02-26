package junia.lab.core.service;

import junia.lab.core.dao.LessonDAO;
import junia.lab.core.entity.Lesson;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LessonService {

    private LessonDAO lessonDAO;

    public LessonService(LessonDAO lessonDAO) {
        this.lessonDAO = lessonDAO;
    }

    public List<Lesson> findAll() {
        return lessonDAO.findAll();
    }

    public Lesson findById(long lessonID){ return lessonDAO.getOneWithTeachersAndStudents(lessonID);}

}
