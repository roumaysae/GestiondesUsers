package com.example.usersappspring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name = "USERS")
@Data
@NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    private  String  userId;
    @Column(unique = true,length = 20,name = "USER_NAME")
    private  String userName;
    private String password;
    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER, cascade = CascadeType.ALL) //eager means each time i want to create a user i'll create with it
    // the roles of this user donc il faut initialiser les roles , pour ne pas avoir une exception de null pointerException
    private List<Role> roles;
}
