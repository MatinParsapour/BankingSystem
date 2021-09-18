package service.impl;

import base.service.BaseServiceImpl;
import domain.User;
import repository.UserRepository;

public class UserServiceImpl extends BaseServiceImpl<User,Long, UserRepository> {
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }
}
