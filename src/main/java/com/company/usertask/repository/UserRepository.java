package com.company.usertask.repository;


import com.company.usertask.entity.Task;
import com.company.usertask.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository< User,Long> {

}
