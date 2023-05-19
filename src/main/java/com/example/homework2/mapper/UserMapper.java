package com.example.homework2.mapper;

import com.example.homework2.dto.user.UserDTO;
import com.example.homework2.dto.user.UserSaveRequest;
import com.example.homework2.dto.user.UserUpdateRequest;
import com.example.homework2.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User convertToUser(UserSaveRequest request);
    User convertToUser(UserUpdateRequest request);
    UserDTO convertToUserDTO(User user);
    List<UserDTO> convertToUserDTOList(List<User> userList);
}
