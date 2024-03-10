package com.example.usersappspring.Services;

import com.example.usersappspring.Repositories.RoleRepository;
import com.example.usersappspring.Repositories.UserRepository;
import com.example.usersappspring.entities.Role;
import com.example.usersappspring.entities.User;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

   /* public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    } */  //on va ajouter allargsConstructor annotation

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString()); //generer un user id as unique value string
        return userRepository.save(user);
    }

    @Override
    public com.example.usersappspring.entities.Role addNewRole(com.example.usersappspring.entities.Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String UserName) {

        return userRepository.findByUserName(UserName);

    }

    @Override
    public Role findRoleByRoleName(String RoleName) {
        return
                roleRepository.findByRoleName(RoleName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
//charger l'user dans la memoire :
        User user = findUserByUserName(userName);
        Role role = findRoleByRoleName(roleName);
        if(user.getRoles() !=null){
            user.getRoles().add(role);
        }
        //in association bidirectional POO :
        // il faut ajouter les roles aux users ainsi qu'on ajoute users to roles
        role.getUsers().add(user);
     //   userRepository.save(user);//c'est pas necessaire d'ajouter save car c'est transactionnel commit sur la modiification de la base de donnees

    }
}
