package com.example.usersappspring.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "ROLES")
@Data
@AllArgsConstructor @NoArgsConstructor

public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;
    @Column(unique = true,length = 20,name = "ROLE_NAME")
    private  String roleName;
    @Column(name = "Description")
    private String desc;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable (name = "USERS_ROLE") // ce n'est pas obligatoire va faire automatique -> on sait d'avance que la relation manyToMany se transforme dans une table qui relait les deux tables user et role
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   // @ManyToMany(mappedBy = "roleList",fetch = FetchType.EAGER, cascade = CascadeType.ALL) //each role has users
    //we can add joined table's name @JoinTable(name = "USERS_ROLES",foreignkey's name1 and name2)
   @ToString.Exclude
    private List<User> users = new ArrayList<>();
}
