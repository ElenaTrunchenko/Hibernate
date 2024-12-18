package ru.netology.JPARep.entity;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonMapper {
    Person toEntity(PersonDto personDto);

    PersonDto toPersonDto(Person person);

    Person updateWithNull(PersonDto personDto, @MappingTarget Person person);
}