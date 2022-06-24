package com.revature.pokebid.history;

import com.revature.pokebid.cardlisting.CardListingService;
import com.revature.pokebid.history.dtos.requests.NewHistoryRequest;
import com.revature.pokebid.pinned.Pinned;
import com.revature.pokebid.pinned.dtos.requests.AddPinnedRequest;
import com.revature.pokebid.status.StatusService;
import com.revature.pokebid.user.UserService;
import com.revature.pokebid.user.dtos.requests.NewUserRequest;
import com.revature.pokebid.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class HistoryService {

    @Inject
    private final HistoryRepository historyRepository;
    private final CardListingService cardListingService;
    private final StatusService statusService;
    private final UserService userService;


    @Inject
    @Autowired
    public HistoryService(HistoryRepository historyRepository, CardListingService cardListingService, StatusService statusService, UserService userService) {
        this.historyRepository = historyRepository;
        this.cardListingService = cardListingService;
        this.statusService = statusService;
        this.userService = userService;
    }

    public List<History> getAllHistory() {
        return (List<History>) historyRepository.findAll();
    }
    public Optional<History> getByHistoryId(String id) {
        return historyRepository.findById(id);
    }



    public List<History> getAllHistoryByUserId(String user_id) {
        return (List<History>) historyRepository.findAllByUserId(user_id);
    }
    public List<History> findAllByUserAndStatus(String user_id, String status_id) {
        System.out.println(user_id);
        System.out.println(status_id);
        return historyRepository.findAllByUserAndStatusId(user_id, status_id);
    }
    public History findByHistoryId(String id) {
        return historyRepository.findByHistoryId(id);
    }

    public History addHistory(NewHistoryRequest request) {
        History history = new History();
        history.setId(UUID.randomUUID().toString());
        history.setTime(Timestamp.from(Instant.now()));
        history.setListing(cardListingService.getCardListingByID(request.getListing_id()));
        history.setStatus(statusService.getStatusById(request.getStatus_id()));
        history.setUsers(userService.getUserById(request.getUser_id()));

        historyRepository.saveHistory(history.getId(), history.getTime(), history.getStatus().getStatus_id(), history.getUsers_id().getId(), history.getListing().getId());
        return history;
    }

}
