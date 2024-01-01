package com.bitebuddies.repository;

import com.bitebuddies.dao.SessionUserEntity;
import com.bitebuddies.dao.SessionUserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface SessionUserRepository extends JpaRepository<SessionUserEntity, SessionUserId> {
    Optional<SessionUserEntity> findBySessionIdAndUserId(Long sessionId, Long userId);

    Set<SessionUserEntity> findAllBySessionId(Long sessionId);
}
