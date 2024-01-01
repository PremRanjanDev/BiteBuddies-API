package com.bitebuddies.dto;

import com.bitebuddies.dao.SessionUserEntity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class SessionDto {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime startsAt;
    private Long initiatedBy;
    private Long pickedRestaurantId;
    private boolean active;
    private Set<SessionUserDto> sessionUsers;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
