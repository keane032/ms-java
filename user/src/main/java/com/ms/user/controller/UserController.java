package com.ms.user.controller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.ms.user.dtos.UserDto;
import com.ms.user.models.Documento;
import com.ms.user.models.Telefone;
import com.ms.user.models.UserModel;
import com.ms.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.status(HttpStatus.CREATED).body("hello");
    }

    @PostMapping("/save")
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserDto user){
        var userModel = new UserModel();
        var documento = new Documento();
        BeanUtils.copyProperties(user, userModel);
        BeanUtils.copyProperties(user.documento(), documento);

        userModel.setDocumento(documento);

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }

    @GetMapping("/users")
    public List<UserModel> listUsers(){
        return userService.findAll();
    }

    @PostMapping("/update")
    public ResponseEntity<UserModel> find(@RequestBody @Valid UserDto user){
        var userModel = new UserModel();
        BeanUtils.copyProperties(user, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.update(userModel));
    }

    // OBS: eu sei que nao e seguro botar ID do usuario na url so
    // estou colocando para servir de exemplo no futuro.
    @PostMapping("/{id}/telefone")
    public ResponseEntity<UserModel> find(
            @PathVariable UUID id,
            @RequestBody Telefone telefone){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.adicionarTelefone(id, telefone));
    }
}
