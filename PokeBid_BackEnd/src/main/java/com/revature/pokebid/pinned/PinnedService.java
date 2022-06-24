package com.revature.pokebid.pinned;


import com.revature.pokebid.cardlisting.CardListingService;
import com.revature.pokebid.pinned.dtos.requests.AddPinnedRequest;
import com.revature.pokebid.user.UserService;
import com.revature.pokebid.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class PinnedService {
    @Inject
    private final PinnedRepository pinnedRepository;
    private final UserService userService;
    private final CardListingService cardListingService;

    @Inject
    @Autowired
    public PinnedService(PinnedRepository pinnedRepository, UserService userService, CardListingService cardListingService) {
        this.pinnedRepository = pinnedRepository;
        this.userService = userService;
        this.cardListingService = cardListingService;
    }

    public Pinned addPinned(AddPinnedRequest request) {
        Pinned pinned = new Pinned();
        pinned.setId(UUID.randomUUID().toString());
        pinned.setUser(userService.getUserById(request.getUser_id()));
        pinned.setCardListing(cardListingService.getCardListingByID(request.getListing_id()));
        pinnedRepository.savePinned(pinned.getId(), pinned.getCardListing(), pinned.getUser());
        return pinned;
    }

    public void deletePinned(String id){
        pinnedRepository.deletePinned(id);
    }
    public List<Pinned> getAllPinnedByUserId(String id){
        return pinnedRepository.getAllPinnedByUserId(id);
    }
    public Optional<Pinned> getByPinnedId(String id){
        return pinnedRepository.findById(id);
    }

    public Pinned getPinnedById(String id) { return pinnedRepository.getPinnedById(id); }
}
