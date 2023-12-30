package com.bitebuddies.repository;

import com.bitebuddies.dao.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<SessionEntity, Long> {

}
