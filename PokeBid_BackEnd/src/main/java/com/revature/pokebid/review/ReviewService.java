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

    @Inject
    @Autowired
    public ReviewService(ReviewRepository reviewRepo){
        this.reviewRepo = reviewRepo;
    }

    public Review createReview(NewReviewRequest request){
        CardListing listing =  new CardListingService(new CardListingRepository() {
            @Override
            public void saveUser(String id, String lister_id, String card_id, String auction_bidder, int auction_bid, String status_id, String condition_id, String card_description, Timestamp time_end) {

            }

            @Override
            public List<String> getAllCardIDByFromCardListings() {
                return null;
            }

            @Override
            public CardListing getCardListingByID(String id) {
                return null;
            }

            @Override
            public <S extends CardListing> S save(S entity) {
                return null;
            }

            @Override
            public <S extends CardListing> Iterable<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<CardListing> findById(String s) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(String s) {
                return false;
            }

            @Override
            public Iterable<CardListing> findAll() {
                return null;
            }

            @Override
            public Iterable<CardListing> findAllById(Iterable<String> strings) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(String s) {

            }

            @Override
            public void delete(CardListing entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends String> strings) {

            }

            @Override
            public void deleteAll(Iterable<? extends CardListing> entities) {

            }

            @Override
            public void deleteAll() {

            }
        }).getCardListingByID(request.getListingId()); //Get Listing
        UserService userService = new UserService(new UserRepository() {
            @Override
            public void saveUser(String id, String username, String password, String address, String email, String role) {

            }

            @Override
            public void updatePasswordById(String password, String id) {

            }

            @Override
            public void updateUser(String username, String password, String address, String email, String role, String id) {

            }

            @Override
            public User getUserByUsernameAndPassword(String username, String password) {
                return null;
            }

            @Override
            public User getUserById(String id) {
                return null;
            }

            @Override
            public List<String> getAllUsername() {
                return null;
            }

            @Override
            public List<String> getAllEmails() {
                return null;
            }

            @Override
            public <S extends User> S save(S entity) {
                return null;
            }

            @Override
            public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<User> findById(String s) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(String s) {
                return false;
            }

            @Override
            public Iterable<User> findAll() {
                return null;
            }

            @Override
            public Iterable<User> findAllById(Iterable<String> strings) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(String s) {

            }

            @Override
            public void delete(User entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends String> strings) {

            }

            @Override
            public void deleteAll(Iterable<? extends User> entities) {

            }

            @Override
            public void deleteAll() {

            }
        });

//        Constructor takes in Listing, User, and Timestamp Objects
        User reviewer = userService.getUserById(request.getReivewerId()); //Set Reviewer
        Timestamp instance = Timestamp.from(Instant.now());

        //Create Review by constructor
        Review rev = new Review(
                UUID.randomUUID().toString(),
                listing,
                reviewer,
                request.getReview(),
                instance
        );
        reviewRepo.registerReview(listing.getId(), listing.getLister().getId(), request.getReivewerId(), rev.getReview());
        return rev;

    }

    public Review updateReview(UpdateReviewRequest request){
        Review rev = getByListingId(request.getListingId());
        Timestamp instance = Timestamp.from(Instant.now());

        rev.setReview(request.getNewReview());
        rev.setTimestamp(instance);

        reviewRepo.updateReview(rev.getReview(), rev.getListing().getId());
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
