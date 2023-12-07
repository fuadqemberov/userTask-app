package com.company.usertask.dto.user;

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
public class UserSimpleDto {

    private String name;
    private String surname;
    private String email;

}
