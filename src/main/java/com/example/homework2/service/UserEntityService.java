package com.example.homework2.service;

import com.example.homework2.dto.user.UserDTO;
import com.example.homework2.dto.user.UserDeleteRequest;
import com.example.homework2.dto.user.UserUpdateRequest;
import com.example.homework2.general.BaseEntityService;
import com.example.homework2.entity.User;
import com.example.homework2.mapper.UserMapper;
import org.springframework.stereotype.Service;
import com.example.homework2.repository.UserRepository;

import java.util.Objects;

@Service

public class UserEntityService extends BaseEntityService<User, UserRepository> {

    private final UserRepository userRepository;

    public UserEntityService(UserRepository repository, UserRepository userRepository) {
        super(repository);
        this.userRepository = userRepository;
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User findByUsernameAndPhoneNumber(String username, String phoneNumber){
        return userRepository.findByUsernameAndPhoneNumber(username,phoneNumber);

    }

    public void delete(UserDeleteRequest userDeleteRequest){
        userRepository.delete(userRepository.findByUsernameAndPhoneNumber(userDeleteRequest.username(), userDeleteRequest.phoneNumber()));
    }

    public UserDTO update(Long id,UserUpdateRequest userUpdateRequest){
        User user = userRepository.findById(id).orElseThrow();
        user.setUsername(userUpdateRequest.username());
        user.setPassword(userUpdateRequest.password());
        user.setEmail(userUpdateRequest.email());
        user.setPhoneNumber(userUpdateRequest.phoneNumber());
        userRepository.save(user);
        return UserMapper.INSTANCE.convertToUserDTO(user);
    }
}
