package com.example.demo.repository;

import com.example.demo.domain.MyUser;
import com.example.demo.domain.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {

    List<Request> findByRecipient(MyUser recipient);
}
