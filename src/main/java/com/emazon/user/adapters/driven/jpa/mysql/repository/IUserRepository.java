package com.emazon.user.adapters.driven.jpa.mysql.repository;

import com.emazon.user.adapters.driven.jpa.mysql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserName(String userName);

}
