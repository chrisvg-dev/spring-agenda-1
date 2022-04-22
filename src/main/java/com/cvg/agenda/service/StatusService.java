package com.cvg.agenda.service;

import com.cvg.agenda.ENUM.StatusEnum;
import com.cvg.agenda.entity.Status;
import com.cvg.agenda.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public Status findByName(StatusEnum status) {
        return this.statusRepository.findByStatus(status).get();
    }

}
