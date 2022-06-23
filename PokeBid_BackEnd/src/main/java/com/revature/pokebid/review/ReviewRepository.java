package com.revature.pokebid.review;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, String> {
    //Inserts & Updates
    @Modifying
    @Query(value = "INSERT INTO reviews (id, listing_id, seller_id, user_id, rating, review, date) VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void registerReview(String id, String listingId, String seller_id, String reviewerId, int rating, String review, Timestamp date);

    @Modifying
    @Query(value = "UPDATE reviews SET rating = ?1, review = ?2 WHERE id = ?3", nativeQuery = true)
    void updateReview(int rating, String review, String id);

    @Modifying
    @Query(value = "DELETE FROM reviews WHERE id = ?1", nativeQuery = true)
    void deleteReview(String id);

    //Select Queries
    @Query(value = "SELECT * from reviews WHERE reviewer_id = ?1", nativeQuery = true)
    List<Review> getAllByReviewerId(String id);

    @Query(value = "SELECT * from reviews where seller_id = ?1", nativeQuery = true)
    List<Review> getAllBySellerId(String id);

    @Query(value = "SELECT * FROM reviews WHERE id = ?1", nativeQuery = true)
    Review getReviewById(String id);
}
