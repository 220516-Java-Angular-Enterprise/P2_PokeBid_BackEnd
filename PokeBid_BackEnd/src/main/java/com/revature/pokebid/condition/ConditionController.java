package com.revature.pokebid.condition;

import com.revature.pokebid.condition.dtos.NewConditionRequest;
import com.revature.pokebid.pinned.Pinned;
import com.revature.pokebid.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/condition")
public class ConditionController {

    @Inject
    private final ConditionService conditionService;

    @Inject
    @Autowired
    public ConditionController(ConditionService conditionService) { this.conditionService = conditionService; }

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/addCondition")
    public @ResponseBody Condition addCondition(@RequestBody NewConditionRequest request){
        return conditionService.addCondition(request);
    }
    
    @CrossOrigin
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Condition> getAllConditions() {
        return conditionService.getAllConditions();
    }

    @CrossOrigin
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Optional<Condition> getByConditionId(@PathVariable String id) {
        return conditionService.getByConditionId(id);
    }
}
