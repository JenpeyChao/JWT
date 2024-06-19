package com.example.JWT.Repository;


import com.example.JWT.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<Users, Integer> {
    @Query(value = "select * from user where username = ?1", nativeQuery = true)
    Optional<Users> findByUsername(String username);
}
