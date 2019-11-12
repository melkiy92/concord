package com.example.concord.repositories;

import com.example.concord.models.User;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
@NoArgsConstructor
public class UserStorage {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void postConstruct() {
        User user = new User(1L, "Test Testov");
        userRepository.save(user);
    }
}
