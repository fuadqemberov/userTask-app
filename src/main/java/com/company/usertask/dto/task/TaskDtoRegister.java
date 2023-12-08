package com.company.usertask.dto.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDtoRegister {


    private String name;
    private String description;

    }
