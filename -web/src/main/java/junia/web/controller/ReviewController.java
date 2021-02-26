package junia.web.controller;

import junia.lab.core.entity.Review;
import junia.lab.core.service.ReviewService;
import junia.web.controller.RestController;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Controller
@Path("/reviews")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReviewController implements RestController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
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

}
