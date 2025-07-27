package com.ms.user.enumcustom;

public enum DiaSemanaEnum {
    DOMINGO("Domingo", 1),
    SEGUNDA("Segunda-feira", 2),
    TERCA("Terça-feira", 3),
    QUARTA("Quarta-feira", 4),
    QUINTA("Quinta-feira", 5),
    SEXTA("Sexta-feira", 6),
    SABADO("Sábado", 7);

    private final String nome;
    private final int numero;

    DiaSemanaEnum(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }
}
