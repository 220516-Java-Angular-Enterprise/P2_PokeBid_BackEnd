package com.revature.pokebid.cardlisting;


import com.revature.pokebid.auth.JwtConfig;
import com.revature.pokebid.cardlisting.dtos.cardlisting.NewCardListingRequest;
import com.revature.pokebid.cardlisting.dtos.cardlisting.UpdateBidderRequest;
import com.revature.pokebid.cardlisting.dtos.cardlisting.UpdateStatusRequest;
import com.revature.pokebid.condition.ConditionService;
import com.revature.pokebid.status.StatusService;
import com.revature.pokebid.user.UserService;
import com.revature.pokebid.util.annotations.Inject;
import com.revature.pokebid.util.cutom_exceptions.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.*;

@Service
@Transactional
public class CardListingService {

    @Inject
    private final CardListingRepository cardListingRepository;
    private final UserService userService;
    private final ConditionService conditionService;
    private final StatusService statusService;

    @Inject
    @Autowired
    public CardListingService(CardListingRepository cardListingRepository, UserService userService, ConditionService conditionService, StatusService statusService) {
        this.cardListingRepository = cardListingRepository;
        this.userService = userService;
        this.conditionService = conditionService;
        this.statusService = statusService;
    }


    public CardListing register(NewCardListingRequest request){
        CardListing cardListing = new CardListing();
        cardListing.setId(UUID.randomUUID().toString());
        cardListing.setLister(userService.getUserById(request.getLister_id()));
        cardListing.setCard_id(request.getCard_id());
        cardListing.setAuction_bid(request.getAuction_bid());
        cardListing.setCondition(conditionService.getConditionById(request.getCondition_id()));
        cardListing.setStatus(statusService.getStatusById(request.getStatus_id()));
        cardListing.setCard_description(request.getDescription());

        int expiration = 7 * 24 * 60 * 60 * 1000; //One week.
        long now = System.currentTimeMillis();
        Date date = new Date(now + expiration);
        cardListing.setTime_end(new Timestamp(date.getTime()));

        cardListingRepository.saveCardListing(cardListing.getId(), cardListing.getLister(), cardListing.getCard_id(), cardListing.getAuction_bidder(), cardListing.getAuction_bid(), cardListing.getStatus(), cardListing.getCondition(), cardListing.getCard_description(), cardListing.getTime_end());
        return cardListing;
    }

    public CardListing updateBidder(UpdateBidderRequest request) {
        CardListing cardListing = getCardListingByID(request.getId());
        cardListing.setAuction_bidder(userService.getUserById(request.getBidder_id()));
        cardListing.setAuction_bid(request.getBid());
        System.out.println(request.getBid());
        cardListingRepository.updateCardListingBidder(cardListing.getAuction_bidder(), request.getBid(), request.getId());
        return cardListing;
    }

    public CardListing updateStatus(UpdateStatusRequest request) {
        CardListing cardListing = getCardListingByID(request.getId());
        cardListing.setStatus(statusService.getStatusById(request.getStatus_id()));

        cardListingRepository.updateCardListingStatus(cardListing.getStatus(), request.getId());
        return cardListing;
    }

    public CardListing getCardListingByID(String id){
        return cardListingRepository.getCardListingByID(id);
    }
    public Optional<CardListing> getByCardListingID(String id){return cardListingRepository.findById(id);}
    public List<CardListing> getAllCardListings() {
        return (List<CardListing>) cardListingRepository.findAll();
    }
    public List<CardListing> getAllCardListingsByUserId(String id) { return (List<CardListing>) cardListingRepository.getAllCardListingsByUserId(id); }
    public List<CardListing> getAllCardListingsByBidderId(String id) { return (List<CardListing>) cardListingRepository.getAllCardListingsByBidderId(id); }
    public void deleteCardListings(String id) { cardListingRepository.deleteCardListings(id); }
    public List<CardListing> getAllCardListingsByStatusId(String status_id) { return cardListingRepository.getAllCardListingsByStatusId(status_id); }
    public List<CardListing> getAllCardListingByCardId(String card_id) { return cardListingRepository.getAllCardListingsByCardId(card_id); }

    /*
    public List<CardListing> getAllCardListingsByCardName(String card_name) {
        List<CardListing> allListings = (List<CardListing>) cardListingRepository.findAll();
        List<CardListing> searchList = new ArrayList<>();
        for (int i = 0; i < allListings.size(); i++) {
            try {
                if (card_name.equals(allListings.get(i).
                        substring(0, input.length())))
                    autoCompleteList.add(advs.get(i));
            } catch (IndexOutOfBoundsException ignore) { }
        }

    } */

    List<String> getAllCardIDByFromCardListings(){
        return cardListingRepository.getAllCardIDFromCardListings();
    }
}
