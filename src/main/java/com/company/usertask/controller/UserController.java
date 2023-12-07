package com.company.usertask.controller;


import com.company.usertask.dto.task.TaskDto;
import com.company.usertask.dto.user.UserDto;
import com.company.usertask.dto.user.UserDtoRegister;
import com.company.usertask.mapper.TaskMapper;
import com.company.usertask.service.taskservice.TaskService;
import com.company.usertask.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
//@RequestMapping("api/v1/")
public class UserController {

    private final UserService service;
    private final TaskService taskService;
    private final TaskMapper taskMapper;


    @GetMapping("/users")
    public ResponseEntity<?> getAll(@RequestParam(value = "page") int page, @RequestParam(value = "count") int count){
       return ResponseEntity.ok(service.getAll(page,count));
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getUserById(id));
    }

   @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        service.deleteById(id);
   }

   @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id,@RequestBody UserDto dto){
        service.updateUser(dto,id);
   }

   @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody @Valid UserDtoRegister dto){
       return ResponseEntity.ok(service.addUser(dto));
   }

    @GetMapping("/userV2/{id}")
    public ResponseEntity<?> getAllTasksForUser(@PathVariable Long id) {
       List<TaskDto> list = taskMapper.toTaskDtoList(taskService.getTasksByUserId(id));
       return ResponseEntity.ok(list);
    }

    @PostMapping("/addtasktouser")
    public ResponseEntity<?> setTaskToUserByUserId(@RequestParam Long userid,@RequestParam Long taskid){
        return ResponseEntity.ok(service.addTaskById(userid,taskid));
    }
}
