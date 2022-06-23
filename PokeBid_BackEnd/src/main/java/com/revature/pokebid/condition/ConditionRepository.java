package com.revature.pokebid.condition;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ConditionRepository extends CrudRepository<Condition, String> {
    @Query(value = "SELECT * FROM card_conditions WHERE condition_id = ?1", nativeQuery = true)
    Condition getConditionById(String id);
    @Modifying
    @Query(value = "INSERT INTO card_conditions (condition_id, condition) VALUES (?1, ?2)", nativeQuery = true)
    void saveCondition(String id, String condition);

}
