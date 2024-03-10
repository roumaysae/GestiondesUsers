package com.example.usersappspring;

import com.example.usersappspring.Services.UserService;
import com.example.usersappspring.entities.Role;
import com.example.usersappspring.entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@SpringBootApplication
public class UsersAppSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersAppSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UserService userService){
        return args ->  {
           /* Stream.of("roumaysae","aymane","ikram").forEach(name -> {
                    User u = new User();
                    u.setUserName(name);
                    u.setPassword("123456");
                    userService.addNewUser(u);
            });*/
            Stream.of("meryem","sundus","abdlah").forEach(name -> {
                User u = new User();
                u.setUserName(name);
                u.setPassword("123789");
                userService.addNewUser(u);
            });
             /*       Stream.of("manager","etudiant","enseignant").forEach(name->{
                        Role r = new Role();
                        r.setRoleName(name);
                        userService.addNewRole(r);
                  });*/

                    Stream.of("docteur","student","prof").forEach(name->{
                        Role r = new Role();
                        r.setRoleName(name);
                        userService.addNewRole(r);
                    });

            //affecter a l'user les roles qu'il convient
      /*      userService.addRoleToUser("Roumaysae","manager");
            userService.addRoleToUser("ikram","enseeignant");
            userService.addRoleToUser("aymane","etudiant");
            userService.addRoleToUser("Roumaysae","enseignant");
*/
        };//lannotation lambda  ca revient au retourner la methode qui je revoit un objet qui a en parametres args
    }
}
