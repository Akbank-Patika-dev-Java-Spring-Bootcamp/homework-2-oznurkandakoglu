package com.example.homework2.service;

import com.example.homework2.general.BaseEntityService;
import com.example.homework2.entity.User;
import org.springframework.stereotype.Service;
import com.example.homework2.repository.UserRepository;

@Service
public class UserService extends BaseEntityService<User, UserRepository> {
    public UserService(UserRepository repository) {
        super(repository);
    }
}
