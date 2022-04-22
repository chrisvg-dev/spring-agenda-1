package com.cvg.agenda.repository;

import com.cvg.agenda.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query("SELECT t FROM Task t WHERE t.activity LIKE %:search%")
    List<Task> findAll(String search);

    boolean existsById(Integer id);

}
