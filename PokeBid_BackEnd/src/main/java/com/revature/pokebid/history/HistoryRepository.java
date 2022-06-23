package com.revature.pokebid.history;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface HistoryRepository extends CrudRepository<History, String> {

    @Modifying
    @Query(value = "INSERT INTO order_history (id, time, status_id, user_id, listing_id) VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void saveHistory(String id, Timestamp time, String status_id, String user_id, String listing_id);

    @Query(value = "SELECT * FROM order_history WHERE user_id = ?1", nativeQuery = true)
    List<History> findAllByUserId(String user_id);

    @Query(value = "SELECT * FROM order_history WHERE user_id = ?1 AND status_id = ?2", nativeQuery = true)
    List<History> findAllByUserAndStatusId(String user_id, String status_id);

    @Query(value = "SELECT * FROM order_history WHERE id = ?1", nativeQuery = true)
    History findByHistoryId(String id);
}
