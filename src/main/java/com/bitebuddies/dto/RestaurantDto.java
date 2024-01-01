package com.bitebuddies.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestaurantDto {
    private Long id;
    private String name;
    private String location;
    private String imageUrl;
}
