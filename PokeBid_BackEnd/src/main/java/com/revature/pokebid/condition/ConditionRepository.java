package com.revature.pokebid.condition;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ConditionRepository extends CrudRepository<Condition, String> {
    @Query(value = "SELECT * FROM conditions WHERE id = ?1", nativeQuery = true)
    Condition findByConditionId(String id);
}
