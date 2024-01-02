package com.bitebuddies.repository;

import com.bitebuddies.dao.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsernameAndPasswordHash(String username, String passwordHash);

    List<UserEntity> findByIdIn(List<Long> ids);
}
