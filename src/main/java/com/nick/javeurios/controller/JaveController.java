package com.nick.javeurios.controller;

import com.nick.javeurios.entity.UserEntity;
import com.nick.javeurios.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JaveController {


    private UserRepository userRepository;

    public JaveController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping(path = "/")
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }
}
