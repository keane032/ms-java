package com.ms.user.repositories;

import com.ms.user.models.UserModel;
import com.ms.user.models.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

    @Query(value="select distinct name from tb_user", nativeQuery = true)
    public List<UserResponse> getUsers();


}
