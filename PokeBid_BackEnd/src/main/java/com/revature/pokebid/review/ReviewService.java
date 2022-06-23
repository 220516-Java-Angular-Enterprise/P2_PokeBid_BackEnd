package com.revature.pokebid.review;

import com.revature.pokebid.cardlisting.CardListing;
import com.revature.pokebid.cardlisting.CardListingRepository;
import com.revature.pokebid.cardlisting.CardListingService;
import com.revature.pokebid.review.dtos.requests.NewReviewRequest;
import com.revature.pokebid.review.dtos.requests.UpdateReviewRequest;
import com.revature.pokebid.user.User;
import com.revature.pokebid.user.UserRepository;
import com.revature.pokebid.user.UserService;
import com.revature.pokebid.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ReviewService {
    @Inject
    private final ReviewRepository reviewRepo;
    private final CardListingService cardListingService;
    private final UserService userService;

    @Inject
    @Autowired
    public ReviewService(ReviewRepository reviewRepo, CardListingService cardListingService, UserService userService) {
        this.reviewRepo = reviewRepo;
        this.cardListingService = cardListingService;
        this.userService = userService;
    }



    public Review createReview(NewReviewRequest request) {
        Review review = new Review();
        review.setId(UUID.randomUUID().toString());
        review.setRating(request.getRating());
        review.setReview(request.getReview());
        review.setListing(cardListingService.getCardListingByID(request.getListingId()));
        review.setSeller(review.getListing().getLister());
        review.setUser(userService.getUserById(request.getReviewerId()));
        review.setTimestamp(Timestamp.from(Instant.now()));
        reviewRepo.registerReview(review.getId(), review.getListing().getId(), review.getSeller().getId(), review.getUser().getId(), review.getRating(), review.getReview(), review.getTimestamp());
        return review;
    }

    public List<Review> getAllReviews() { return (List<Review>) reviewRepo.findAll(); }

    public List<Review> getAllByReviewerId(String id) { return reviewRepo.getAllByReviewerId(id); }

    public List<Review> getAllBySellerId(String id) { return reviewRepo.getAllBySellerId(id); }

    public Optional<Review> getByReviewId(String id) { return reviewRepo.findById(id); }

    public Review getReviewById(String id) { return reviewRepo.getReviewById(id); }

    public void deleteReview(String id) { reviewRepo.deleteReview(id); }

    public Review updateReview(UpdateReviewRequest request) {
        Review review = getReviewById(request.getId());
        review.setReview(request.getNewReview());
        review.setRating(request.getNewRating());
        reviewRepo.updateReview(request.getNewRating(), request.getNewReview(), request.getId());
        return review;
    }
}
