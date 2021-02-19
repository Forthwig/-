package junia.lab.core.dao;

import junia.lab.core.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewDAO extends JpaRepository<Review, Long> {
}
