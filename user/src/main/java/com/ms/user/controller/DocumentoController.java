package com.ms.user.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping(path="/documento")
public class DocumentoController {

    @PostMapping("/upload")
    public ResponseEntity<String> upload(
             @RequestParam("pdf") MultipartFile arquivo ){
        if(arquivo.isEmpty()){
            return ResponseEntity.badRequest().body("Arquivo vazio");
        }

        return ResponseEntity.status(200).body("ok");
    }

}
