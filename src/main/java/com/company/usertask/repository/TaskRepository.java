package com.company.usertask.repository;

import com.company.usertask.dto.task.TaskDto;
import com.company.usertask.entity.Task;

import com.company.usertask.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query(value = "select t.id , t.name , t.description  from user_tasks ut \n" +
            "join task t on t.id  = ut.task_id \n" +
            "where ut.user_id =  :id",nativeQuery = true)
    List<Task> getTasksByUserId(Long id);

    @Query("SELECT new com.company.usertask.dto.task.TaskDto(t.id,t.name,t.description) FROM Task t")
    List<TaskDto> findAllTasks();

    List<Task> findTasksByUsers(User user);


}
