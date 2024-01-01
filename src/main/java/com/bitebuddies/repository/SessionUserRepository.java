package com.bitebuddies.repository;

import com.bitebuddies.dao.SessionUserEntity;
import com.bitebuddies.dao.SessionUserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface SessionUserRepository extends JpaRepository<SessionUserEntity, SessionUserId> {
    Optional<SessionUserEntity> findBySessionIdAndUserId(Long sessionId, Long userId);
}
