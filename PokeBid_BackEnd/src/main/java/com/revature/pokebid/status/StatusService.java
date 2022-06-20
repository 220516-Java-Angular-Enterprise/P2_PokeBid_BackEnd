package com.revature.pokebid.status;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    public Status getStatusById(String id) {
        return statusRepository.findStatusById(id);
    }
}
