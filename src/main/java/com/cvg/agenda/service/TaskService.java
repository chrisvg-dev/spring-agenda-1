package com.cvg.agenda.service;

import com.cvg.agenda.ENUM.StatusEnum;
import com.cvg.agenda.dto.TaskDTO;
import com.cvg.agenda.entity.Status;
import com.cvg.agenda.entity.Task;
import com.cvg.agenda.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    StatusService statusService;

    public List<Task> getAllTasks(){
        return this.taskRepository.findAll();
    }

    public List<Task> getAllTasksByFilter(String filter){
        return this.taskRepository.findAll(filter);
    }

    public void create (TaskDTO task) {
        try {
            LocalDateTime fecha = LocalDateTime.parse(task.getDate());
            Status status = this.statusService.findByName( StatusEnum.CREATED );
            Task newTask = Task.builder()
                    .id(0)
                    .activity(task.getActivity())
                    .date( fecha )
                    .estimated(task.getEstimated())
                    .status( status )
                    .createdAt( LocalDateTime.now() )
                    .build();
            this.taskRepository.save(newTask);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean delete(Integer id) {
        if (this.taskRepository.existsById(id)) {
            this.taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
