package com.company.usertask.service.taskservice;

import com.company.usertask.dto.task.TaskDto;
import com.company.usertask.dto.task.TaskDtoRegister;
import com.company.usertask.entity.Task;

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
