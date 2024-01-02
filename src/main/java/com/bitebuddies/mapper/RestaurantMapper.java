package com.bitebuddies.mapper;

import com.bitebuddies.dao.RestaurantEntity;
import com.bitebuddies.dto.RestaurantDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    RestaurantDto map(RestaurantEntity entity);

    List<RestaurantDto> map(List<RestaurantEntity> entities);

    @Mapping(target = "id", ignore = true)
    RestaurantEntity mapForCreate(RestaurantDto restaurantDto);
}
