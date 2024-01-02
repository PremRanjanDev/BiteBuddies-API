package com.bitebuddies.repository;

import com.bitebuddies.dao.SessionRestaurantEntity;
import com.bitebuddies.dao.SessionRestaurantId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRestaurantRepository extends JpaRepository<SessionRestaurantEntity, SessionRestaurantId> {

    List<SessionRestaurantEntity> findAllBySessionId(Long sessionId);
}

