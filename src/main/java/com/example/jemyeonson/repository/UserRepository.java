package com.example.jemyeonson.repository;

import com.example.jemyeonson.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Modifying
    @Transactional
    @Query(value = "insert into User (username, password) values (:username, :password)")
    void insertUser(@Param("username") String username, @Param("password") String password);
}
