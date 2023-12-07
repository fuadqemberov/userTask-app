package com.company.usertask.controller;

import com.company.usertask.dto.TaskDto;
import com.company.usertask.entity.Task;
import com.company.usertask.mapper.TaskMapper;
import com.company.usertask.repository.TaskRepository;
import com.company.usertask.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;


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
