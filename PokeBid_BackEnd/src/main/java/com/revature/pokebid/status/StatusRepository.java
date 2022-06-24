package com.revature.pokebid.status;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, String> {

    @Query(value = "SELECT * FROM statuses WHERE status_id = ?1", nativeQuery = true)
    Status getStatusById(String id);

    @Modifying
    @Query(value = "INSERT INTO statuses (status_id, status) VALUES (?1, ?2)", nativeQuery = true)
    void saveStatus(String id, String status);

}
