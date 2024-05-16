package com.example.demo.repository;

import com.example.demo.domain.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyUserDetailsRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByUserName(String userName);
}
