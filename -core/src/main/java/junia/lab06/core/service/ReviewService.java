package junia.lab06.core.service;

import junia.lab06.core.dao.ReviewDAO;
import junia.lab06.core.entity.Review;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ReviewService {

    private ReviewDAO reviewDAO;


    public ReviewService(ReviewDAO reviewDAO) {
        this.reviewDAO = reviewDAO;
    }


    public void save(Review review) {
        reviewDAO.save(review);
    }

    public void deleteReviewById(long reviewId) {
        reviewDAO.deleteById(reviewId);
    }
}
