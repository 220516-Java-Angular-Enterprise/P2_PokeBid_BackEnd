package com.revature.pokebid.status;

import com.revature.pokebid.condition.Condition;
import com.revature.pokebid.condition.dtos.NewConditionRequest;
import com.revature.pokebid.status.dtos.NewStatusRequest;
import com.revature.pokebid.util.annotations.Inject;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class StatusService {

    @Inject
    private final StatusRepository statusRepository;

    @Inject
    @Autowired
    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public Status addStatus(NewStatusRequest request) {
        Status status = new Status(UUID.randomUUID().toString(), request.getStatus());
        statusRepository.saveStatus(status.getStatus_id(), status.getStatus());
        return status;
    }

    public List<Status> getAllStatuses() { return (List<Status>) statusRepository.findAll(); }
    public Optional<Status> getByStatusId(String id) {
        return statusRepository.findById(id);
    }
    public Status getStatusById(String id) {
        return statusRepository.getStatusById(id);
    }

}
