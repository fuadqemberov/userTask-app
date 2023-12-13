package com.company.usertask.repository;

import com.company.usertask.dto.user.UserDto;
import com.company.usertask.dto.user.UserSimpleDto;
import com.company.usertask.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface UserCustomRepository {
    List<UserDto> findAllPageByCriteria(Specification<User> spec, Pageable pageable);
}
