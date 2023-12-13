package com.company.usertask.repository;

import com.company.usertask.dto.user.UserDto;
import com.company.usertask.dto.user.UserSimpleDto;
import com.company.usertask.entity.User;
import com.company.usertask.mapper.UserMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import java.util.List;

public class UserCustomRepositoryImpl implements UserCustomRepository{

   private final UserMapper mapper;

    @PersistenceContext
    private EntityManager entityManager;

    public UserCustomRepositoryImpl(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<UserDto> findAllPageByCriteria(Specification<User> spec, Pageable pageable) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);

        if (spec!=null){
            Predicate predicate;
            predicate = spec.toPredicate(root,cq,cb);
            cq.where(predicate);
        }

        TypedQuery<User> typedQuery = entityManager.createQuery(cq);

        typedQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        typedQuery.setMaxResults(pageable.getPageSize());

        return mapper.toUserDtoList(typedQuery.getResultList());
    }



 }

