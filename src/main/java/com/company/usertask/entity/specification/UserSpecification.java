package com.company.usertask.entity.specification;

import com.company.usertask.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;


@Component
public class UserSpecification {

    public static Specification<User> containsSurname(String surname){
        return ((root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("surname"),"%"+ surname + "%");
        });
    }


    public static Specification<User> surnameContains(String keyword) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("surname")),
                        "%" + keyword.toLowerCase() + "%"
                );
    }


}
