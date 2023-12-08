package com.company.usertask.service.userservice;


import com.company.usertask.dto.user.UserDto;
import com.company.usertask.dto.user.UserDtoRegister;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
   List<UserDto> getAll(int page,int count);
   UserDto getUserById(Long id);
   UserDto updateUser(UserDto user , Long id);
   void deleteById(Long id);
   ResponseEntity<?> addUser(UserDtoRegister dto);
   UserDto addTaskById(Long userId, Long taskId);

}
