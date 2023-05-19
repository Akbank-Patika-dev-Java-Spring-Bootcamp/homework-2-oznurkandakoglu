package com.example.homework2.repository;

import com.example.homework2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long>{

    @Query(
            "select user from User user where user.username = :username "
    )
    User findByUsername(@Param("username")String username);

    @Query(
            "select user FROM User user WHERE user.username = :username AND user.phoneNumber = :phoneNumber"
    )
    User findByUsernameAndPhoneNumber(@Param("username")String username, @Param("phoneNumber") String phoneNumber);
}
