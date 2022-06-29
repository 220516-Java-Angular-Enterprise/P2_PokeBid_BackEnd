package com.revature.pokebid.pinned;

import com.revature.pokebid.history.History;
import com.revature.pokebid.pinned.dtos.requests.AddPinnedRequest;
import com.revature.pokebid.review.Review;
import com.revature.pokebid.review.ReviewService;
import com.revature.pokebid.review.dtos.requests.NewReviewRequest;
import com.revature.pokebid.review.dtos.requests.UpdateReviewRequest;
import com.revature.pokebid.util.annotations.Inject;
import com.revature.pokebid.util.cutom_exceptions.InvalidRequestException;
import com.revature.pokebid.util.cutom_exceptions.ResourceConflictException;
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
@RequestMapping("/pinned")
public class PinnedController {
    @Inject
    private final PinnedService pinnedService;

    @Inject
    @Autowired
    public PinnedController(PinnedService pinnedService){
        this.pinnedService = pinnedService;
    }

    @CrossOrigin
    @GetMapping(value = "/pinnedCards/{user_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Pinned> getAllPinnedByUserId(@PathVariable String user_id) {
        return pinnedService.getAllPinnedByUserId(user_id);
    }

    @CrossOrigin
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Optional<Pinned> getByPinnedId(@PathVariable String id) {
        return pinnedService.getByPinnedId(id);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Pinned addPinned(@RequestBody AddPinnedRequest request){
        return pinnedService.addPinned(request);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.GONE)
    @RequestMapping("/removePinned")
    @DeleteMapping
    public @ResponseBody String deletePinned(@RequestBody String id){
        pinnedService.deletePinned(id);
        return id;
    }

    @CrossOrigin
    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody Map<String, Object> handleResourceConflictException(ResourceConflictException e) {
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("status", 409);
        responseBody.put("message", e.getMessage());
        responseBody.put("timestamp", LocalDateTime.now().toString());
        return responseBody;
    }

    @CrossOrigin
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