package com.revature.pokebid.history;

import com.revature.pokebid.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    public History getHistoryById(String id) {
        return historyRepository.findByHistoryId(id);
    }
}
