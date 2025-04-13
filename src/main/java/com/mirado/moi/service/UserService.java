package com.mirado.moi.service;

import com.mirado.moi.entity.User;
import com.mirado.moi.repository.UserRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class UserService {

    @Inject
    private UserRepository userRepository;

    public User login(String email, String password) throws Exception {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            throw new Exception("Email ou mot de passe invalide.");
        }
    }

    public User register(User user) {
        return userRepository.create(user);
    }
}
