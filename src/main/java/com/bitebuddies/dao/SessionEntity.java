package com.bitebuddies.dao;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "sessions")
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE sessions SET deleted = true WHERE id = ?")
public class SessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    private String description;
    private LocalDateTime startsAt;
    @ManyToOne
    @JoinColumn(name = "initiated_by", nullable = false)
    private UserEntity initiatedBy;
    private Long pickedRestaurantId;
    private boolean active;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
