package com.ms.user.exceptions;

import java.util.UUID;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException() {
        super("Usuário não encontrado.");
    }
}