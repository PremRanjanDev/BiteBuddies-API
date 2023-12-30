package com.bitebuddies.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity(name="session")
public class SessionEntity {
    @Id
    private Long id;
    private Long initiatedBy;
    private Long pickedRestaurantId;
    private boolean active;
    private LocalDateTime createdAt;

}
