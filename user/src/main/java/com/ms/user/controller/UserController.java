package com.ms.user.controller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.ms.user.dtos.UserDto;
import com.ms.user.models.UserModel;
import com.ms.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserDto user){
        var userModel = new UserModel();
        BeanUtils.copyProperties(user, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }

    @GetMapping("/users")
    public List<UserModel> listUsers(){
        return userService.findAll();
    }

}
