package com.ms.user.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionsHandler {
    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> handleUsuarioNaoEncontrado(UsuarioNaoEncontradoException ex) {
        Map<String, String> erro = new HashMap<>();
        erro.put("status", "404");
        erro.put("erro", "Usuário não encontrado");
        erro.put("mensagem", ex.getMessage());  // Isso pega o "Usuário não encontrado." do construtor da exception
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }


}
