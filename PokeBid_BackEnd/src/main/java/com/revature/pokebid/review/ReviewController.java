package com.revature.pokebid.review;

import com.revature.pokebid.review.dtos.requests.NewReviewRequest;
import com.revature.pokebid.review.dtos.requests.UpdateReviewRequest;
import com.revature.pokebid.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Inject
    private final ReviewService reviewService;

    @Inject
    @Autowired
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/createReview")
    public @ResponseBody Review createReview(@RequestBody NewReviewRequest request){
        return reviewService.createReview(request);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping("/updateReview")
    @PutMapping
    public @ResponseBody Review updateReview(@RequestBody UpdateReviewRequest request){
        return reviewService.updateReview(request);
    }

    @ResponseStatus(HttpStatus.GONE)
    @RequestMapping("/deleteReview")
    @DeleteMapping
    public @ResponseBody String deleteReview(@RequestBody String id){
        reviewService.deleteReview(id);
        return id;
    }


}
