package com.company.usertask.controller;

import com.company.usertask.dto.task.TaskDto;
import com.company.usertask.mapper.TaskMapper;
import com.company.usertask.repository.TaskRepository;
import com.company.usertask.service.taskservice.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor

public class TaskController {

    private final TaskService service;
    private final TaskRepository repository;
    private final TaskMapper mapper;

    @GetMapping("/tasks")
    public ResponseEntity<?> getAll(){
       return ResponseEntity.ok(service.getAllTasks());
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getTaskById(id));
    }

    @PostMapping("/addtask")
    public void createTask(@RequestBody TaskDto dto){
        repository.save(mapper.toTaskEntity(dto));
    }

//    @GetMapping
//    public ResponseEntity<Page<Task>> getAllTaskInPage(@RequestParam(defaultValue = "0", required = false) int page,
//                                                       @RequestParam(defaultValue = "10", required = false) int size,
//                                                       @RequestParam(defaultValue = "createdAt", required = false) String sorting,
//                                                       @RequestParam(defaultValue = "desc", required = false) String direction)) {
//        Page<Task> products = repository.findAll((org.springframework.data.domain.Pageable) pageable);
//        return ResponseEntity.ok(products);
//    }






}
