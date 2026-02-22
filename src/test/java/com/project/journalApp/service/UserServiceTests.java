package com.project.journalApp.service;

import com.project.journalApp.entity.User;
import com.project.journalApp.repository.UserRepository;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional   // ✅ THIS is the key
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAdd() {

        User user = new User();
        user.setUsername("test_user_" + System.currentTimeMillis());
        user.setPassword("12345");
        user.setJournalEntries(new ArrayList<>());

        userRepository.save(user);

        User savedUser =
                userRepository.findByusername(user.getUsername());

        assertNotNull(savedUser);
        assertNotNull(savedUser.getJournalEntries());
    }
}