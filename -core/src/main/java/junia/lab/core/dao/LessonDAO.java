package junia.lab.core.dao;

import junia.lab.core.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LessonDAO extends JpaRepository<Lesson, Long> {

    @Query("SELECT DISTINCT l FROM Lesson l LEFT JOIN FETCH l.Teachers LEFT JOIN FETCH l.reviews LEFT JOIN FETCH  l.Students WHERE l.id=:id")
    Lesson getOneWithTeachersAndReviewsAndStudents(@Param("id") long lessonID);

}
