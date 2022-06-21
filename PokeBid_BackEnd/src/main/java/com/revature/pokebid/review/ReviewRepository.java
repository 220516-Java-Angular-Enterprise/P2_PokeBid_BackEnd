package com.revature.pokebid.review;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, String> {
    //Inserts & Updates
    @Modifying
    @Query(value = "INSERT INTO reviews (listing_id, seller_id, reviewer_id, review) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void registerReview(String listingId, String sellerId, String reviewerId, String review);

    @Modifying
    @Query(value = "UPDATE reviews SET review = ?1 WHERE listing_id = ?2", nativeQuery = true)
    void updateReview(String review, String listingId);

    @Modifying
    @Query(value = "DELETE FROM reviews WHERE listing_id = ?1", nativeQuery = true)
    void deleteReview(String id);

    //Select Queries
    @Query(value = "SELECT * from reviews WHERE reviewer_id = ?1", nativeQuery = true)
    List<Review> getAllByReviewId(String id);

    @Query(value = "SELECT * from reviews where seller_id = ?1", nativeQuery = true)
    List<Review> getBySellerId(String id);

    @Query(value = "SELECT * FROM reviews WHERE listing_id = ?1", nativeQuery = true)
    Review getByListingId(String id);
}
