package junia.lab.core.dao;

import junia.lab.core.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonDAO extends JpaRepository<Lesson, Long> {
}
