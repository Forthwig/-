package junia.web.controller;

import junia.lab.core.entity.Review;
import junia.lab.core.service.ReviewService;
import junia.web.controller.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("/reviews")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReviewController implements RestController {

    private static ReviewController instance;

    public static ReviewController getInstance(){
        return instance;
    }

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
        instance = this;
    }

    @POST
    @Path("")
    public void saveReview(Review review){
        reviewService.save(review);
    }

    @DELETE
    @Path("/{reviewId}")
    public void deleteReviewById(@PathParam("reviewId") long reviewId){
        reviewService.deleteReviewById(reviewId);
    }

    public List<Review> getReviewByStudent(Long studenId){
        return reviewService.getReviewByStudent(studenId);
    }

}
