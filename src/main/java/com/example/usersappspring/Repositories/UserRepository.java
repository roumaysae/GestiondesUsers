package com.example.usersappspring.Repositories;

import com.example.usersappspring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String userName);
}
