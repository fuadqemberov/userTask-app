package com.company.usertask.service;


import com.company.usertask.dto.TaskDtoRegister;
import com.company.usertask.dto.UserDto;
import com.company.usertask.dto.UserDtoRegister;

import java.util.List;

public interface UserService {
   List<UserDto> getAll(int page,int count);
   UserDto getUserById(Long id);
   UserDto updateUser(UserDto user , Long id);
   void deleteById(Long id);
   UserDtoRegister addUser(UserDtoRegister dto);
   UserDto addTaskById(Long userId, Long taskId);

}
