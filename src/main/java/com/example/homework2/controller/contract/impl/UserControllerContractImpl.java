package com.example.homework2.controller.contract.impl;

import com.example.homework2.controller.contract.UserControllerContract;
import com.example.homework2.dto.user.UserDTO;
import com.example.homework2.dto.user.UserDeleteRequest;
import com.example.homework2.dto.user.UserSaveRequest;
import com.example.homework2.dto.user.UserUpdateRequest;
import com.example.homework2.entity.User;
import com.example.homework2.exception.UsernameAndPhoneNumberNotMatchException;
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
        User user = userEntityService.findByUsername(username);
        return UserMapper.INSTANCE.convertToUserDTO(user);
    }

    @Override
    public void delete(UserDeleteRequest userDeleteRequest) {
        User user = userEntityService.findByUsername(userDeleteRequest.username());
        if(!user.getPhoneNumber().equals(userDeleteRequest.phoneNumber()) || !user.getUsername().equals(userDeleteRequest.username())){
            throw new UsernameAndPhoneNumberNotMatchException(userDeleteRequest.username() + " username and " + userDeleteRequest.phoneNumber() + " phone number not match!");
        }
        userEntityService.delete(user);
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
