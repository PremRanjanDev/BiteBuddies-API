package com.bitebuddies.dao;

import com.bitebuddies.model.InviteStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "session_users")
public class SessionUserEntity {

    @EmbeddedId
    private SessionUserId id;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false, insertable = false, updatable = false)
    private SessionEntity session;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private UserEntity user;
    @Enumerated(EnumType.STRING)
    private InviteStatus status;
    private LocalDateTime invitedAt;
    private LocalDateTime joinedAt;

    public SessionUserEntity(Long sessionId, Long userId, InviteStatus status) {
        this.id = new SessionUserId();
        this.id.setSessionId(sessionId);
        this.id.setUserId(userId);
        this.status = status;
    }

    @PrePersist
    protected void onCreate() {
        if (InviteStatus.joined.equals(status)) {
            joinedAt = LocalDateTime.now();
        } else {
            invitedAt = LocalDateTime.now();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        if (InviteStatus.joined.equals(status)) {
            joinedAt = LocalDateTime.now();
        }
    }
}
