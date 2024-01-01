package com.bitebuddies.mapper;

import com.bitebuddies.dao.UserEntity;
import com.bitebuddies.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "username", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    UserDto map(UserEntity entity);

    Collection<UserDto> map(Collection<UserEntity> entities);

    @Mapping(target = "id", ignore = true)
    UserEntity mapForCreate(UserDto req);

    @Mapping(target = "id", ignore = true)
    void mapForUpdate(@MappingTarget UserEntity entity, UserDto req);
}
