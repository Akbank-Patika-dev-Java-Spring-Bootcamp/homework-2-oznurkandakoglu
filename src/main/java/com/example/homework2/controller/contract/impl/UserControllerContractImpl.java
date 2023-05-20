package com.example.homework2.controller.contract.impl;

import com.example.homework2.controller.contract.UserControllerContract;
import com.example.homework2.dto.user.UserDTO;
import com.example.homework2.dto.user.UserDeleteRequest;
import com.example.homework2.dto.user.UserSaveRequest;
import com.example.homework2.dto.user.UserUpdateRequest;
import com.example.homework2.entity.User;
import com.example.homework2.mapper.UserMapper;
import com.example.homework2.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserControllerContractImpl implements UserControllerContract
{
    private final UserEntityService userEntityService;

    @Override
    public List<UserDTO> findAll() {
        List<User> userList = userEntityService.findAll();
        return UserMapper.INSTANCE.convertToUserDTOList(userList);
    }

    @Override
    public UserDTO findById(Long id) {
        User user = userEntityService.findById(id).orElseThrow();
        return UserMapper.INSTANCE.convertToUserDTO(user);
    }

    @Override
    public UserDTO findByUsername(String username) {
        return userEntityService.findByUsername(username);
    }

    @Override
    public void delete(UserDeleteRequest userDeleteRequest) {
        userEntityService.delete(userDeleteRequest);
    }

    @Override
    public UserDTO update(Long id, UserUpdateRequest userUpdateRequest) {
        return userEntityService.update(id, userUpdateRequest);
    }

    @Override
    public UserDTO save(UserSaveRequest userSaveRequest) {
        User user = UserMapper.INSTANCE.convertToUser(userSaveRequest);
        user = userEntityService.save(user);
        return UserMapper.INSTANCE.convertToUserDTO(user);
    }
}
