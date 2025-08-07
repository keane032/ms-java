package com.ms.user.repositories;

import com.ms.user.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.UUID;

public class UsuarioRepositoryNativeImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<UserModel> buscarPorId(UUID userId) {
        String sql = "SELECT id, nome, email FROM clientes where id = ?";

        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(UserModel.class), userId);
    }
}
