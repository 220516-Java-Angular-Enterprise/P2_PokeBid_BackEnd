package com.revature.pokebid.notification;

import com.revature.pokebid.cardlisting.CardListing;
import com.revature.pokebid.user.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

public interface NotificationRepository extends CrudRepository<Notification, String> {

    @Modifying
    @Query(value = "INSERT INTO notifications (id, user_id, card_listing_id, message) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void newNotification(String id, User user, CardListing auction, String message);

    @Query (value= "SELECT * FROM notifications WHERE user_id = ?1", nativeQuery = true)
    List<Notification> getAllNotificationsByUser(String user_id);

    @Modifying
    @Query(value = "DELETE FROM notifications WHERE id = ?1", nativeQuery = true)
    void deleteNotification(String id);
}
