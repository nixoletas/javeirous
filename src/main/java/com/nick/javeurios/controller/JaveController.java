package com.nick.javeurios.controller;

import com.nick.javeurios.entity.UserEntity;
import com.nick.javeurios.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/carga")
public class JaveController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/")
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    @PostMapping(path = "/")
    public UserEntity create(@RequestBody UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    @PutMapping("/{id}")
    public UserEntity update(@PathVariable("id") UUID id, @RequestBody UserEntity userEntity) {
        if (userRepository.existsById(id)) {
            userEntity.setId(id);
            return userRepository.save(userEntity);
        } else {
            throw new RuntimeException("not found");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") UUID id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("not found");
        }
    }
}
