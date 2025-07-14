package org.example.springbootadvance.mappers;

import org.example.springbootadvance.entity.UserCreateDto;
import org.example.springbootadvance.entity.Users;
import org.mapstruct.*;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)public interface UsersMapper {


    Users fromCreatDto(UserCreateDto userCreateDto);

//    UserCreateDto toDto(Users users);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Users partialUpdate(UserCreateDto userCreateDto, @MappingTarget Users users);
}