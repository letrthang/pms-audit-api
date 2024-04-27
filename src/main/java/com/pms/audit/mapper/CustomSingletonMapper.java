package com.pms.audit.mapper;

import lombok.Generated;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Generated
public class CustomSingletonMapper {
    private static final CustomSingletonMapper INSTANCE = new CustomSingletonMapper();
    private final ModelMapper mapper;

    public static CustomSingletonMapper getInstance() {
        return INSTANCE;
    }

    public CustomSingletonMapper() {
        mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public <E> E toEntity(Class<E> clazz, Object dto){
        return ObjectUtils.isEmpty(dto) ? null : mapper.map(dto, clazz);
    }

    public <V> V toDto(Class<V> clazz, Object entity){
        return !ObjectUtils.isEmpty(entity) && !entity.equals(Optional.empty()) ? mapper.map(entity, clazz) : null;
    }

    public void mapProperties(Object src, Object dest) {
        mapper.map(src, dest);
    }
}
