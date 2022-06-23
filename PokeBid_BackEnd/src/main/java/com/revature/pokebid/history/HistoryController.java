package com.revature.pokebid.history;

import com.revature.pokebid.history.dtos.requests.NewHistoryRequest;
import com.revature.pokebid.pinned.Pinned;
import com.revature.pokebid.pinned.dtos.requests.AddPinnedRequest;
import com.revature.pokebid.review.Review;
import com.revature.pokebid.util.annotations.Inject;
import com.revature.pokebid.util.cutom_exceptions.InvalidRequestException;
import com.revature.pokebid.util.cutom_exceptions.ResourceConflictException;
import org.hibernate.usertype.UserCollectionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/history")
public class HistoryController {
    @Inject
    private final HistoryService historyService;

    @Inject
    @Autowired
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }
    @CrossOrigin
    @GetMapping(value = "/users/{user_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<History> getAllHistoryByUserId(@PathVariable String user_id) {
        return historyService.getAllHistoryByUserId(user_id);
    }
    @CrossOrigin
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Optional<History> getByHistoryId(@PathVariable String id) {
        return historyService.getByHistoryId(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody History addHistory(@RequestBody NewHistoryRequest request){
        return historyService.addHistory(request);
    }
    @GetMapping
    public @ResponseBody List<History> getAllHistories() {
        return historyService.getAllHistory();
    }

    @CrossOrigin
    @GetMapping(value = "/userSearch/{user_id}/{status_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<History> getAllByUserAndStatus(@PathVariable String user_id, @PathVariable String status_id) {
        return historyService.findAllByUserAndStatus(user_id, status_id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody Map<String, Object> handleResourceConflictException(ResourceConflictException e) {
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("status", 409);
        responseBody.put("message", e.getMessage());
        responseBody.put("timestamp", LocalDateTime.now().toString());
        return responseBody;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody Map<String, Object> handleBadRequestException(InvalidRequestException e) {
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("status", 400);
        responseBody.put("message", e.getMessage());
        responseBody.put("timestamp", LocalDateTime.now().toString());
        return responseBody;
    }
}
