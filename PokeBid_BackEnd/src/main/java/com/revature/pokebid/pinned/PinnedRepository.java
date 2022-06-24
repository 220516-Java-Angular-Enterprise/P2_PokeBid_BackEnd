package com.revature.pokebid.pinned;

import com.revature.pokebid.cardlisting.CardListing;
import com.revature.pokebid.review.Review;
import com.revature.pokebid.user.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PinnedRepository extends CrudRepository<Pinned, String> {
    //Inserts & Updates
    @Modifying
    @Query(value = "INSERT INTO pinned_cards (id, listing_id, user_id) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void savePinned(String id, CardListing listing_id, User user_id);

    @Modifying
    @Query(value = "DELETE FROM pinned_cards WHERE id = ?1", nativeQuery = true)
    void deletePinned(String id);

    //Select Queries
    @Query(value = "SELECT * from pinned_cards WHERE user_id = ?1", nativeQuery = true)
    List<Pinned> getAllPinnedByUserId(String id);

    @Query(value = "SELECT * FROM pinned_cards WHERE id = ?1", nativeQuery = true)
    Pinned getPinnedById(String id);
}