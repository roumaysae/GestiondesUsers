package com.example.usersappspring.Services;

import com.example.usersappspring.entities.Role;
import com.example.usersappspring.entities.User;

public interface UserService {
    User addNewUser(User user);

    com.example.usersappspring.entities.Role addNewRole(com.example.usersappspring.entities.Role role);
 //we can find a user based on userName
    User findUserByUserName(String UserName);
    Role findRoleByRoleName(String RoleName);
    void addRoleToUser(String userName , String roleName); // add role to an user(UserName is unique and ROLENAME is unique)

}
