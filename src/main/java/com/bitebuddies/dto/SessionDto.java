package com.bitebuddies.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SessionDto {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime startsAt;
    private Long initiatedBy;
    private Long pickedRestaurantId;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
