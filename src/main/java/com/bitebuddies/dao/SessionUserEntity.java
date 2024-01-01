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
    @MapsId("sessionId")
    @JoinColumn(name = "session_id")
    private SessionEntity session;
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @Enumerated(EnumType.STRING)
    private InviteStatus status;
    private LocalDateTime invitedAt;
    private LocalDateTime joinedAt;

    public SessionUserEntity(SessionEntity session, UserEntity user, InviteStatus status) {
        this.session = session;
        this.user = user;
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
