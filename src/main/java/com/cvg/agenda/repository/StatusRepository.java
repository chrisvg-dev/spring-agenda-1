package com.cvg.agenda.repository;

import com.cvg.agenda.ENUM.StatusEnum;
import com.cvg.agenda.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
    Optional<Status> findByStatus(StatusEnum status);
}
