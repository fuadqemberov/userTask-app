package com.company.usertask.dto.user;


import com.company.usertask.dto.task.TaskDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.util.List;


@Component
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Integer id;
    @NotBlank(message="Ad yeri bosh ola bilmez !")
    private String name;
    @NotBlank(message="Soyad yeri bosh ola bilmez !")
    private String surname;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotBlank(message="Email yeri bosh ola bilmez !")
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnore
    private String password;

    private List<TaskDto> tasks;





}
