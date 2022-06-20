package com.revature.pokebid.review;

import com.revature.pokebid.review.dtos.requests.NewReviewRequest;
import com.revature.pokebid.review.dtos.requests.UpdateReviewRequest;
import com.revature.pokebid.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
@Transactional
public class ReviewService {
//GetAllByUserId (Get reviews under a user)
//GetAllByReviewerId (Get Reviews made by a reviewer)
//GetByReviewId (Get Review by ID)

    @Inject
    private final ReviewRepository reviewRepo;

    @Inject
    @Autowired
    public ReviewService(ReviewRepository reviewRepo){
        this.reviewRepo = reviewRepo;
    }

    public Review createReview(NewReviewRequest request){
        CardListing listing =  new CardListingService.getById(request.getListingId());
        UserService userService = new UserService(UserRepository userRepo);

//        Constructor takes in Listing, User, and Timestamp Objects
        User seller = userService.getById(listing.getListerId);
        User reviewer = userService.getById(listing.getReviewerId);
        Timestamp instance = Timestamp.from(Instant.now());


        Review rev = new Review(
                listing,
                seller,
                reviewer,
                request.getReview(),
                instance
        );
        reviewRepo.registerReview(listing.getId, seller.getId, reviewer.getId, rev.getReview());
        return rev;

    }

    public Review updateReview(UpdateReviewRequest request){
        Review rev = getByListingId(request.getListingId());
        Timestamp instance = Timestamp.from(Instant.now());

        rev.setReview(request.getNewReview());
        rev.setTimestamp(instance);

        reviewRepo.updateReview(rev.getReview(), rev.getListing().getId);
        return rev;
    }


    public void deleteReview(String id){
        reviewRepo.deleteReview(id);
    }



    //Gets
    public List<Review> getAllByReviewerId(String id){
        return reviewRepo.getAllByReviewId(id);
    }

    public List<Review> getAllBySellerId(String id){
        return reviewRepo.getBySellerId(id);
    }

    public Review getByListingId(String id){
        return reviewRepo.getByListingId(id);
    }

}
