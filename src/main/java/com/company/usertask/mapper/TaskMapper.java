package com.company.usertask.mapper;


import com.company.usertask.dto.task.TaskDto;
import com.company.usertask.dto.task.TaskDtoRegister;
import com.company.usertask.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {



    TaskDto toTaskDto(Task task);

    Task toTaskEntity(TaskDto taskDto);

    List<Task> totaskEntityList(List<TaskDto> taskDtoList);

    List<TaskDto> toTaskDtoList(List<Task> taskList);

    TaskDtoRegister toTaskReg(Task task);

    Task fromRegtoEntity(TaskDtoRegister dto);

}
