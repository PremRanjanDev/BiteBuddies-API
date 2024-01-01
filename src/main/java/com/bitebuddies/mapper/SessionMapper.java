package com.bitebuddies.mapper;

import com.bitebuddies.dao.SessionEntity;
import com.bitebuddies.dto.SessionDto;
import org.mapstruct.*;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring",
        uses = {UserMapper.class, SessionUserMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SessionMapper {
    SessionDto map(SessionEntity entity);
    Collection<SessionDto> map(Collection<SessionEntity> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    SessionEntity mapForCreate(SessionDto req);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "initiatedBy", ignore = true)
    void mapForUpdate(@MappingTarget SessionEntity entity, SessionDto req);
}
