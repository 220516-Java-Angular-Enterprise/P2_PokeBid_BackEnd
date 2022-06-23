package com.revature.pokebid.cardlisting;

import com.revature.pokebid.condition.Condition;
import com.revature.pokebid.status.Status;
import com.revature.pokebid.user.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

public interface CardListingRepository extends CrudRepository<CardListing, String> {
    @Modifying
    @Query(value = "INSERT INTO card_listings (id, user_id, card_id, auction_bidder, auction_bid, status, condition, card_description, time_end) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9)", nativeQuery = true)
    void saveCardListing(String id, User lister_id, String card_id, User auction_bidder, int auction_bid, Status status_id, Condition condition_id, String card_description, Timestamp time_end);

    @Query (value = "SELECT card_id FROM card_listings", nativeQuery = true)
    List<String> getAllCardIDFromCardListings();

    @Query(value = "SELECT * FROM card_listings WHERE id = ?1", nativeQuery = true)
    CardListing getCardListingByID(String id);

    @Query(value = "SELECT * FROM card_listings WHERE auction_bidder = ?1", nativeQuery = true)
    List<CardListing> getAllCardListingsByBidderId(String id);

    @Query(value = "SELECT * FROM card_listings WHERE user_id = ?1", nativeQuery = true)
    List<CardListing> getAllCardListingsByUserId(String id);
    @Modifying
    @Query(value = "UPDATE card_listings SET auction_bidder = ?1, auction_bid = ?2 WHERE id = ?3", nativeQuery = true)
    void updateCardListingBidder(User auction_bidder, int auction_bid, String id);

    @Modifying
    @Query(value = "UPDATE card_listings SET status = ?1 WHERE id = ?2", nativeQuery = true)
    void updateCardListingStatus(Status status, String id);

}
