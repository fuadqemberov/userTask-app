package com.company.usertask.service;

import com.company.usertask.dto.TaskDto;
import com.company.usertask.dto.TaskDtoRegister;
import com.company.usertask.dto.UserDto;
import com.company.usertask.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;


public interface TaskService {
    List<TaskDto> getAllTasks();
    TaskDto getTaskById(Long id);
    TaskDto updateTask(Task user);
    void deleteById(Long id);
    List<Task> getTasksByUserId(Long userId);
    TaskDtoRegister addTask(TaskDtoRegister dto);
    //PageContainer<Task> getAllPageable(int page, int size, String sorting, String direction);

}
