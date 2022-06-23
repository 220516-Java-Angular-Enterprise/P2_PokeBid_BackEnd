package com.revature.pokebid.history;

import com.revature.pokebid.history.dtos.requests.NewHistoryRequest;
import com.revature.pokebid.pinned.Pinned;
import com.revature.pokebid.pinned.dtos.requests.AddPinnedRequest;
import com.revature.pokebid.user.dtos.requests.NewUserRequest;
import com.revature.pokebid.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Inject
    @Autowired
    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public List<History> getAllHistory() {
        return (List<History>) historyRepository.findAll();
    }

    public List<History> getAllHistoryByUserId(String user_id) {
        return (List<History>) historyRepository.findAllByUserId(user_id);
    }
    public Optional<History> getByHistoryId(String id) {
        return historyRepository.findById(id);
    }

    public History addHistory(NewHistoryRequest request) {
        History history = new History(UUID.randomUUID().toString(),Timestamp.from(Instant.now()), request);
        historyRepository.saveHistory(history.getId(), history.getTime(), history.getStatus().getStatus_id(), history.getUsers_id().getId(), history.getListing_id().getId());
        return history;
    }

}
