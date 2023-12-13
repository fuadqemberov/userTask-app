package com.company.usertask.dto.user;



import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.stereotype.Component;


@Component
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoRegister {


    @NotBlank(message="Ad yeri bosh ola bilmez !")
    private String name;

    @NotBlank(message="Soyad yeri bosh ola bilmez !")
    private String surname;


    @NotBlank(message="Email yeri bosh ola bilmez !")
    private String email;


    private String password;

}
