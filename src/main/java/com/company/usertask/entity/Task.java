package com.company.usertask.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "task")
@NoArgsConstructor

public class Task extends BaseEntity<Long>{

    private String description;

    @ToString.Exclude
    @ManyToMany(mappedBy = "tasks")
    private Set<User> users = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(description, task.description) &&
                Objects.equals(users, task.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, users);
    }
}
