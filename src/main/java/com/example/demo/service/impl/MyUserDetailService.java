package com.example.demo.service.impl;

import com.example.demo.domain.MyUser;
import com.example.demo.dto.RegistrationRequest;
import com.example.demo.principal.MyUserDetails;
import com.example.demo.repository.MyUserDetailsRepository;
import com.example.demo.service.MyMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MyUserDetailService implements UserDetailsService {

    private final MyUserDetailsRepository myUserDetailsRepository;
    private final PasswordEncoder passwordEncoder;
    private final MyMailService myMailService;

    @Autowired
    public MyUserDetailService(MyUserDetailsRepository myUserDetailsRepository,
                               PasswordEncoder passwordEncoder,
                               MyMailService myMailService) {
        this.myUserDetailsRepository = myUserDetailsRepository;
        this.passwordEncoder = passwordEncoder;
        this.myMailService = myMailService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return myUserDetailsRepository.findByUserName(s)
                .map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User name not found: " + s));
    }

    public void register(RegistrationRequest registrationRequest) {
        MyUser myUser = MyUser.builder()
                .active(true)
                .email(registrationRequest.getEmail())
                .userName(registrationRequest.getUserName())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .roles("ROLE_USER")
                .joinDate(LocalDateTime.now())
                .build();
        myUserDetailsRepository.save(myUser);
        myMailService.sendEmail(myUser.getEmail(), "registration confirmation",
                myMailService.registrationNotification(registrationRequest));
    }

    public void adminUser(Long userId) {
        MyUser myUser = myUserDetailsRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + userId));
        myUser.setRoles("ROLE_ADMIN");
        myUserDetailsRepository.save(myUser);
    }
}