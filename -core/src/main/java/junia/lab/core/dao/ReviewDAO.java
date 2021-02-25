package junia.lab.core.dao;

import junia.lab.core.entity.Lesson;
import junia.lab.core.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewDAO extends JpaRepository<Review, Long> {

}
