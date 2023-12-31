package com.company.usertask.entity;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.*;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends  BaseEntity<Long> {


   @Column(name = "surname", nullable = false)
   private String surname;

   @Column(name="email", nullable = false)
    private String email;

   @Column(name="password")
    private String password;

    @ManyToMany(cascade = { CascadeType.ALL },fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_tasks",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "task_id") }
    )
    private List<Task> tasks = new ArrayList<>();

}
