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
    private final UserMapper userMapper = UserMapper.INSTANCE;

    public UserEntityService(UserRepository repository, UserRepository userRepository) {
        super(repository);
        this.userRepository = userRepository;
    }

    public UserDTO findByUsername(String username){
        User user = userRepository.findByUsername(username);
        return UserMapper.INSTANCE.convertToUserDTO(user);
    }

    public UserDTO findByUsernameAndPhoneNumber(String username, String phoneNumber){
        User user = userRepository.findByUsernameAndPhoneNumber(username,phoneNumber);
        return UserMapper.INSTANCE.convertToUserDTO(user);

    }

    public void delete(UserDeleteRequest userDeleteRequest){
        User user = userRepository.findByUsername(userDeleteRequest.username());
        if(user.getPhoneNumber().equals(userDeleteRequest.phoneNumber())){
            userRepository.deleteById(user.getId());
        }
    }

    public UserDTO update(Long id,UserUpdateRequest userUpdateRequest){
        User user = userRepository.findById(id).orElseThrow();
        user.setUsername(userUpdateRequest.username());
        user.setPassword(userUpdateRequest.password());
        user.setEmail(userUpdateRequest.email());
        user.setPhoneNumber(userUpdateRequest.phoneNumber());
        userRepository.save(user);
        return userMapper.convertToUserDTO(user);
    }
}
