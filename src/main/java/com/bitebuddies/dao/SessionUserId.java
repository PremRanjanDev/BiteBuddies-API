package com.bitebuddies.dao;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class SessionUserId implements Serializable {

    private Long sessionId;
    private Long userId;
}