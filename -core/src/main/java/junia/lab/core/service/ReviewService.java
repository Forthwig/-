package junia.lab.core.service;

import junia.lab.core.dao.ReviewDAO;
import junia.lab.core.entity.Review;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    public List<Review> getReviewByStudent(long studenId){return reviewDAO.getReviewByStudent(studenId);}

    public List<Review> getReviewByLessonByTeacher(long teacherId){return reviewDAO.getReviewByLessonByTeacher(teacherId);}

    public List<Review> getReview(){ return  reviewDAO.findAll();}

}
