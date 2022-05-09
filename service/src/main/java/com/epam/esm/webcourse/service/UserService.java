package com.epam.esm.webcourse.service;

import com.epam.esm.webcourse.entity.User;
import com.epam.esm.webcourse.repository.RoleRepository;
import com.epam.esm.webcourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;
    private final RoleRepository roleRepository;
    @Autowired
    public UserService(UserRepository repository, RoleRepository roleRepository) {
        this.repository = repository;
        this.roleRepository = roleRepository;
    }

    public void registration(User user) {
        user.setRole(roleRepository.findByName("user"));
        repository.save(user);
    }

    public boolean login(User user) {
        boolean result = true;
        User userFromDB = repository.findByEmail(user.getEmail());
        if(userFromDB == null || !userFromDB.getPassword().equals(user.getPassword())) {
            result = false;
        }
        return result;
    }
}
