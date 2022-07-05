package com.revature.pokebid.status;

import com.revature.pokebid.condition.Condition;
import com.revature.pokebid.condition.ConditionService;
import com.revature.pokebid.condition.dtos.NewConditionRequest;
import com.revature.pokebid.status.dtos.NewStatusRequest;
import com.revature.pokebid.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Inject
    private final StatusService statusService;

    @Inject
    @Autowired
    public StatusController(StatusService statusService) { this.statusService = statusService; }

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/addStatus")
    public @ResponseBody Status addStatus(@RequestBody NewStatusRequest request){
        return statusService.addStatus(request);
    }

    @CrossOrigin
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Status> getAllStatuses() {
        return statusService.getAllStatuses();
    }

    @CrossOrigin
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Optional<Status> getByStatusId(@PathVariable String id) {
        return statusService.getByStatusId(id);
    }
}
