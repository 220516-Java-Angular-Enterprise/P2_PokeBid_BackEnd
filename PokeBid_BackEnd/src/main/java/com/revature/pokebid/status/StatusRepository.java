package com.revature.pokebid.status;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, String> {

    @Query(value = "SELECT status FROM statuses WHERE status_id = ?1", nativeQuery = true)
    Status findStatusById(String id);


}
