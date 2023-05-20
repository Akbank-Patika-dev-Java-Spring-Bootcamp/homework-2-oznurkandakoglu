package com.example.homework2.controller.contract;

import com.example.homework2.dto.user.UserDTO;
import com.example.homework2.dto.user.UserDeleteRequest;
import com.example.homework2.dto.user.UserSaveRequest;
import com.example.homework2.dto.user.UserUpdateRequest;

import java.util.List;

public interface UserControllerContract {

    List<UserDTO> findAll();
    UserDTO findById(Long id);
    UserDTO findByUsername(String username);
    void delete(UserDeleteRequest userDeleteRequest);
    UserDTO update(Long id, UserUpdateRequest userUpdateRequest);
    UserDTO save (UserSaveRequest userSaveRequest);
}
