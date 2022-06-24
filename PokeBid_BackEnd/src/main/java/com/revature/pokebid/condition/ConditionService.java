package com.revature.pokebid.condition;

import com.revature.pokebid.condition.dtos.NewConditionRequest;
import com.revature.pokebid.status.Status;
import com.revature.pokebid.status.StatusRepository;
import com.revature.pokebid.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ConditionService {
    @Inject
    private final ConditionRepository conditionRepository;

    @Inject
    @Autowired
    public ConditionService(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    public Condition addCondition(NewConditionRequest request) {
        Condition condition = new Condition(UUID.randomUUID().toString(), request.getCondition());
        conditionRepository.saveCondition(condition.getCondition_id(), condition.getCondition());
        return condition;
    }

    public List<Condition> getAllConditions() {
        return (List<Condition>) conditionRepository.findAll();
    }
    public Optional<Condition> getByConditionId(String id){
        return conditionRepository.findById(id);
    }
    public Condition getConditionById(String id){
        return conditionRepository.getConditionById(id);
    }

}
