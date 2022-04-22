package com.cvg.agenda.controller;

import com.cvg.agenda.dto.ResponseDTO;
import com.cvg.agenda.dto.TaskDTO;
import com.cvg.agenda.entity.Task;
import com.cvg.agenda.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping({"", "/{filter}"})
    public ResponseEntity<List<Task>> getAllTasks(
            @PathVariable(name = "filter", required = false) String filter){
        if (filter == null) {
            return ResponseEntity.ok(this.taskService.getAllTasks());
        }
        return ResponseEntity.ok(this.taskService.getAllTasksByFilter(filter));
    }
    @PostMapping
    public ResponseEntity<ResponseDTO> create(@RequestBody TaskDTO taskDTO){
        this.taskService.create(taskDTO);

        return ResponseEntity.ok( ResponseDTO.builder().message("REGISTRO EXITOSO").build() );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> create(@PathVariable Integer id){
        boolean resp = this.taskService.delete(id);

        return resp
                ? ResponseEntity.ok( ResponseDTO.builder().message("REGISTRO ELIMINADO").build() )
                : ResponseEntity.ok( ResponseDTO.builder().message("REGISTRO NO ELIMINADO").build() );
    }
}
