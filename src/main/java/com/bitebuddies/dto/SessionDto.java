package com.bitebuddies.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class SessionDto {
    private Long id;
    private Long initiatedBy;
    private Long pickedRestaurantId;
    private boolean active;
    private LocalDateTime createdAt;
}
