package com.bitebuddies.mapper;

import com.bitebuddies.dao.RestaurantEntity;
import com.bitebuddies.dto.RestaurantDto;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    RestaurantDto map(RestaurantEntity entity);

    Collection<RestaurantDto> map(Collection<RestaurantEntity> entities);

}
