package com.company.usertask.dto.task;

import lombok.*;
import org.springframework.stereotype.Component;


@Component
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private Long id;
    private String name;
    private String description;

    }
