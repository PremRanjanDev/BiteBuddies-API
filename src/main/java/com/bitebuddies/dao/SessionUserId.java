package com.bitebuddies.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class SessionUserId implements Serializable {

    @Column(name = "session_id")
    private Long sessionId;

    @Column(name = "user_id")
    private Long userId;
}