package junia.web.controller;

import junia.lab.core.entity.Review;
import junia.lab.core.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Controller
@Path("/reviews")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReviewController implements RestController {

    private static ReviewController instance;
    private ReviewService reviewService;

    public static ReviewController getInstance(){
        return instance;
    }

    private static final Logger logger =  LoggerFactory.getLogger(ReviewController.class);

    public ReviewController(ReviewService reviewService) {
        logger.info("Initialisation ReviewController");
        this.reviewService = reviewService;
        instance = this;
    }
    /** Web **/

    /** API **/

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
