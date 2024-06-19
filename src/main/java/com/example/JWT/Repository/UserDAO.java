package com.example.JWT.Repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
    @Query(value = "select * from user where username = ?1", nativeQuery = true)
    Optional<User> findByUsername(String username);
}
