package junia.lab.core.dao;

import junia.lab.core.entity.Lesson;
import junia.lab.core.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewDAO extends JpaRepository<Review, Long> {

    @Query("SELECT DISTINCT r FROM Review r WHERE r.student.id=:id")
    public List<Review> getReviewByStudent(@Param("id") long StudenId);

    @Query("SELECT DISTINCT r FROM Review r LEFT JOIN FETCH r.teacher t  WHERE t.id=:id")
    public List<Review> getReviewAndTeacher(@Param("id") long teacherId);

}
