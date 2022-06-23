package com.revature.pokebid.cardlisting;

import com.revature.pokebid.cardlisting.dtos.cardlisting.NewCardListingRequest;
import com.revature.pokebid.cardlisting.dtos.cardlisting.UpdateBidderRequest;
import com.revature.pokebid.cardlisting.dtos.cardlisting.UpdateStatusRequest;
import com.revature.pokebid.user.User;
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
@RequestMapping("/cardListing")
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
    @CrossOrigin
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Optional<CardListing> getByCardListingId(@PathVariable String id) {
        return cardListingService.getByCardListingID(id);
    }
    @CrossOrigin
    @GetMapping(value = "/seller/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CardListing> getAllCardListingsByUserId(@PathVariable String id) { return cardListingService.getAllCardListingsByUserId(id); }
    @CrossOrigin
    @GetMapping(value = "/bidder/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CardListing> getAllCardListingsByBidderId(@PathVariable String id) { return cardListingService.getAllCardListingsByBidderId(id); }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String registerListing(@RequestBody NewCardListingRequest request){
        return cardListingService.register(request).getId();
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(value = "/updateBidder", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody CardListing updateBidder(@RequestBody UpdateBidderRequest request) {
        return cardListingService.updateBidder(request);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(value = "/updateStatus", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody CardListing updateStatus(@RequestBody UpdateStatusRequest request) {
        return cardListingService.updateStatus(request);
    }
     @ExceptionHandler
     @ResponseStatus(HttpStatus.CONFLICT)
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
