package com.company.usertask.service;


import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.usertask.dto.UserDto;
import com.company.usertask.dto.UserDtoRegister;
import com.company.usertask.entity.Task;
import com.company.usertask.entity.User;
import com.company.usertask.exception.UserNotFoundException;
import com.company.usertask.mapper.TaskMapper;
import com.company.usertask.mapper.UserMapper;
import com.company.usertask.repository.TaskRepository;
import com.company.usertask.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

;


@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final TaskRepository  trepository;
    private final TaskMapper taskMapper;
    private final UserMapper mapper;
    private final TaskService tservice;




    @Override
    public List<UserDto> getAll(int page,int count) {

        return mapper.toUserDtoList(repository.findAll(PageRequest.of(page,count)).getContent());
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = repository.findById(id).orElseThrow(()-> new UserNotFoundException("User Tapilmadi ! "));
        return mapper.toUserDto(user);
    }


    @Override
    public UserDto updateUser(UserDto userdto,Long id){
       User u  = repository.findById(id).orElseThrow(()-> new UserNotFoundException("User Tapilmadi !"));
       User u2 = mapper.updateUser(u,userdto);
       u2.setId(id);
       return mapper.toUserDto(repository.save(u2));
    }


     @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    BCrypt.Hasher crypt = BCrypt.withDefaults();
    @Override
    public UserDtoRegister addUser(UserDtoRegister dto) {
      dto.setPassword(crypt.hashToString(4,dto.getPassword().toCharArray()));
      //List<TaskDto> list = dto.getTasks();
//      dto.setTasks();
     return mapper.toUserRegister(repository.save(mapper.toUserEntity2(dto)));
    }

    @Override
    public UserDto addTaskById(Long userid, Long taskId) {

       User u =  repository.findById(userid).orElseThrow(()-> new UserNotFoundException("User Tapilmadi !"));
       Task t = trepository.findById(taskId).get();
       List<Task> list = tservice.getTasksByUserId(userid);
       list.add(t);
       u.setTasks(list);
       return mapper.toUserDto(repository.save(u));
    }


}
