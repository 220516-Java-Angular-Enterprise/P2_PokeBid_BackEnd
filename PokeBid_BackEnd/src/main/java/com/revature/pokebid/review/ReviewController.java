package com.revature.pokebid.review;

import com.revature.pokebid.cardlisting.CardListing;
import com.revature.pokebid.review.dtos.requests.NewReviewRequest;
import com.revature.pokebid.review.dtos.requests.UpdateReviewRequest;
import com.revature.pokebid.util.annotations.Inject;
import com.revature.pokebid.util.cutom_exceptions.InvalidRequestException;
import com.revature.pokebid.util.cutom_exceptions.ResourceConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public @ResponseBody Review createReview(@RequestBody NewReviewRequest request){
        return reviewService.createReview(request);
    }

    @GetMapping
    public @ResponseBody List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @CrossOrigin
    @GetMapping(value = "/reviewer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Review> getAllByReviewerId(@PathVariable String id) {
        return reviewService.getAllByReviewerId(id);
    }
    @CrossOrigin
    @GetMapping(value = "/seller/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Review> getAllBySellerId(@PathVariable String id) {
        return reviewService.getAllBySellerId(id);
    }
    @CrossOrigin
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Optional<Review> getByReviewId(@PathVariable String id) {
        return reviewService.getByReviewId(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping("/updateReview")
    @PutMapping
    public @ResponseBody Review updateReview(@RequestBody UpdateReviewRequest request) {
        return reviewService.updateReview(request);
    }

    @ResponseStatus(HttpStatus.GONE)
    @DeleteMapping(value = "/deleteReview/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String deleteReview(@PathVariable String id){
        reviewService.deleteReview(id);
        return id;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody Map<String, Object> handleResourceConflictException(ResourceConflictException e){
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("status", 400);
        responseBody.put("message", e.getMessage());
        responseBody.put("timestamp", LocalDateTime.now().toString());
        return responseBody;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody Map<String, Object> handleBadRequestException(InvalidRequestException e){
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("status", 400);
        responseBody.put("message", e.getMessage());
        responseBody.put("timestamp", LocalDateTime.now().toString());
        return responseBody;
    }
}
