package com.company.usertask.service.userservice;


import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.usertask.dto.user.UserDto;
import com.company.usertask.dto.user.UserDtoRegister;
import com.company.usertask.entity.Task;
import com.company.usertask.entity.User;
import com.company.usertask.entity.specification.UserSpecification;
import com.company.usertask.error.SuccessMessage;
import com.company.usertask.exception.UserNotFoundException;
import com.company.usertask.mapper.TaskMapper;
import com.company.usertask.mapper.UserMapper;
import com.company.usertask.repository.TaskRepository;
import com.company.usertask.repository.UserRepository;
import com.company.usertask.response.MessageResponse;
import com.company.usertask.service.taskservice.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> addUser(UserDtoRegister dto) {
      dto.setPassword(crypt.hashToString(4,dto.getPassword().toCharArray()));
     repository.save(mapper.toUserEntity2(dto));
     return MessageResponse.response(SuccessMessage.SUCCESS_ADD, mapper.toSimpleDto(dto), null, HttpStatus.OK);
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

    @Override
    public List<UserDto> getEmployeeByCriteria(int page, int size,  String surname) {
        Specification<User> where = Specification.where(UserSpecification.surnameContains(surname));
        Pageable pageable = PageRequest.of(page, size);
        return  repository.findAllPageByCriteria(where, pageable);

    }




}

