package service;

import entity.User;
import general.BaseEntityService;
import org.springframework.stereotype.Service;
import repository.UserRepository;

@Service
public class UserService extends BaseEntityService<User, UserRepository> {
    public UserService(UserRepository repository) {
        super(repository);
    }
}
