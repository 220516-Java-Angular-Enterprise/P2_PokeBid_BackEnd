package com.revature.pokebid.cardlisting;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;

public interface CardListingRepository extends CrudRepository<CardListing, String> {

    @Modifying
    @Query(value = "INSERT INTO card_listings (id, lister_id, card_id, auction_bidder, auction_bid, status_id, condition_id, card_description, time_end) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9)", nativeQuery = true)
    void saveUser(String id, String lister_id, String card_id, String auction_bidder, int auction_bid, String status_id, String condition_id, String card_description, Timestamp time_end);

    @Query (value = "SELECT card_id FROM card_listings", nativeQuery = true)
    List<String> getAllCardIDByFromCardListings();

    @Query(value = "SELECT * FROM card_listings WHERE id = ?1", nativeQuery = true)
    CardListing getCardListingByID(String id);

}
