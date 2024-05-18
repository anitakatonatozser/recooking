package com.example.demo.controller;

import com.example.demo.dto.AuthenticationRequest;
import com.example.demo.dto.AuthenticationResponse;
import com.example.demo.dto.RegistrationRequest;
import com.example.demo.service.impl.MyUserDetailService;
import com.example.demo.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class AuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtTokenUtil;
    private final MyUserDetailService myUserDetailService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtUtil jwtTokenUtil, MyUserDetailService myUserDetailService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.myUserDetailService = myUserDetailService;
    }

    @PostMapping("/api/authenticate")
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUserName(),
                        authenticationRequest.getPassword()
                )
        );

        final UserDetails userDetails = myUserDetailService
                .loadUserByUsername(authenticationRequest.getUserName());

        final String jwt = jwtTokenUtil.generateToken(userDetails);
        logger.info(authenticationRequest.getUserName() + " user has been authenticated.");
        return new AuthenticationResponse(jwt);
    }

    @PostMapping("/api/register")
    public void register(@RequestBody RegistrationRequest registrationRequest) {
        myUserDetailService.register(registrationRequest);
        logger.info(registrationRequest.getUserName() + " user has been registered.");
    }

    @PutMapping("/api/admin/{id}")
    public void adminUser(@PathVariable("id") Long userId) {
        log.info("User with id: " + userId + " has been given admin rights");
        myUserDetailService.adminUser(userId);
    }
}