package com.revature.pokebid.cardlisting;


import com.revature.pokebid.auth.JwtConfig;
import com.revature.pokebid.cardlisting.dtos.cardlisting.NewCardListingRequest;
import com.revature.pokebid.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CardListingService {

    @Inject
    private final CardListingRepository cardListingRepository;

    @Inject
    @Autowired
    public CardListingService(CardListingRepository cardListingRepository){
        this.cardListingRepository = cardListingRepository;
    }

    public CardListing register(NewCardListingRequest request){
        CardListing cardListing = request.ExtractCardListing();

        if (true) { //Change to verify valid listing
            int expiration = 7 * 24 * 60 * 60 * 1000; //One week.
            long now = System.currentTimeMillis();
            cardListing.setTime_end((Timestamp) new Date(now + expiration));
        }

        return cardListing;
    }

    public CardListing getCardListingByID(String id){
        return cardListingRepository.getCardListingByID(id);
    }
    public List<CardListing> getAllCardListings() {
        return (List<CardListing>) cardListingRepository.findAll();
    }

    List<String> getAllCardIDByFromCardListings(){
        return cardListingRepository.getAllCardIDByFromCardListings();
    }
}
