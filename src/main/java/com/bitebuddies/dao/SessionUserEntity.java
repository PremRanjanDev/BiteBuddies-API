package com.bitebuddies.dao;

import com.bitebuddies.model.InviteStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
//@NoArgsConstructor
@Entity
@Table(name = "session_users")
public class SessionUserEntity {

    @EmbeddedId
    private SessionUserId id;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false, insertable = false, updatable = false)
//    @Column(insertable = false, updatable = false)
    private SessionEntity session;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private UserEntity user;

    //    @Column(name = "status", length = 10, nullable = false, columnDefinition = "VARCHAR(10) DEFAULT 'invited'")
    @Enumerated(EnumType.STRING)
    private InviteStatus status;

    //    @Column(name = "invited_at")
    private LocalDateTime invitedAt;

    //    @Column(name = "joined_at")
    private LocalDateTime joinedAt;

    // composite primary key


//    public SessionUserEntity(SessionEntity session, UserEntity user, InviteStatus status) {
//        this.session = session;
//        this.user = user;
//        this.status = status;
//    }

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
