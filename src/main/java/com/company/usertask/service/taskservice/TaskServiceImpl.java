package com.company.usertask.service;

import com.company.usertask.dto.TaskDto;
import com.company.usertask.dto.TaskDtoRegister;
import com.company.usertask.entity.Task;
import com.company.usertask.entity.User;
import com.company.usertask.mapper.TaskMapper;
import com.company.usertask.repository.TaskRepository;
import com.company.usertask.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository repository;
    private final TaskMapper mapper;
    private final UserRepository repo;
    private final TaskRepository taskRepo;

    @Override
    public List<TaskDto> getAllTasks() {
        return repository.findAllTasks();
    }

    @Override
    public TaskDto getTaskById(Long id) {
        return  mapper.toTaskDto(repository.findById(id).get());
    }

    @Override
    public TaskDto updateTask(Task task) {
        return mapper.toTaskDto(repository.save(task));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Task> getTasksByUserId(Long userId) {
        User user = repo.findById(userId).get();
        List<Task> tasksByUsers = taskRepo.getTasksByUserId(user.getId());
        return tasksByUsers;
    }

    @Override
    public TaskDtoRegister addTask(TaskDtoRegister dto) {
       return mapper.toTaskReg(repository.save(mapper.fromRegtoEntity(dto)));
    }

//    @Override
//    public Page<Task> getAllProducts(Pageable pageable) {
//        return taskRepo.findAll((org.springframework.data.domain.Pageable) pageable);
//    }






}
