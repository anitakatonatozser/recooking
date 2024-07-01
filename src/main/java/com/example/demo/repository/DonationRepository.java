package com.example.demo.repository;

import com.example.demo.domain.Donation;
import com.example.demo.domain.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    List<Donation> findByDonor(MyUser donor);
}
