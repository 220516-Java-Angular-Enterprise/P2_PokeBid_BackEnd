package com.revature.pokebid.condition;

import com.revature.pokebid.status.Status;
import com.revature.pokebid.status.StatusRepository;
import com.revature.pokebid.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ConditionService {
    @Inject
    private final ConditionRepository conditionRepository;

    @Inject
    @Autowired

    public ConditionService(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    public List<Condition> getAllConditions() {
        return (List<Condition>) conditionRepository.findAll();
    }

    public Condition getConditionById(String id){
        return conditionRepository.findByConditionId(id);
    }
}
