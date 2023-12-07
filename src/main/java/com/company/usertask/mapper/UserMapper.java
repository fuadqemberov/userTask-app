package com.company.usertask.mapper;


import com.company.usertask.dto.UserDto;
import com.company.usertask.dto.UserDtoRegister;
import com.company.usertask.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING )
public interface UserMapper {



    UserDto toUserDto(User user);

    User toUserEntity(UserDto userDto);

    List<User> toEntityList(List<UserDto> dtoList);

    List<UserDto> toUserDtoList(List<User> userList);

    User updateUser(@MappingTarget User user, UserDto dto);

    User toUserEntity2(UserDtoRegister regDto);

    UserDtoRegister toUserRegister(User user);

}
