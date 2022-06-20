package com.revature.pokebid.cardlisting;

import com.revature.pokebid.cardlisting.dtos.cardlisting.NewCardListingRequest;
import org.graalvm.compiler.graph.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cardlisting")
public class CardListingController {
    @Inject
    private final CardListingService cardListingService;

    @Inject
    @Autowired
    public CardListingController(CardListingService cardListingService){
        this.cardListingService = cardListingService;
    }

    @GetMapping
    public @ResponseBody List<CardListing> getAllCardListings() {
        return cardListingService.getAllCardListings();
    }

     @ResponseStatus(HttpStatus.CREATED)
     @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
     public @ResponseBody String register(@RequestBody NewCardListingRequest request){
        return cardListingService.register(request).getId();
    }

     @ExceptionHandler
     @ResponseBody(HttpStatus.CONFLICT)
     public @ResponseBody Map<String, Object> handleResourceConflictException(ResourceConflictException e){
         Map<String, Object> responseBody = new LinkedHashMap<>();
         responseBody.put("status", 400);
         responseBody.put("message", e.getMessage());
         responseBody.put("timestamp", LocalDateTime.now().toString());
         return responseBody;
     }

     @ExceptionHandler
     @ResponseStatus(HttpStatus.BAD_REQUEST)
     public @ResponseBody Map<String, Object> handleBadRequestException(InvalidRequestException e){
         Map<String, Object> responseBody = new LinkedHashMap<>();
         responseBody.put("status", 400);
         responseBody.put("message", e.getMessage());
         responseBody.put("timestamp", LocalDateTime.now().toString());
         return responseBody;
     }

}
