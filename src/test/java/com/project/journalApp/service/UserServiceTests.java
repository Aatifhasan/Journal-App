package com.project.journalApp.service;

import com.project.journalApp.entity.User;
import com.project.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAdd() {
        // Test user creation logic
        assertEquals(2, 1 + 1);
        User user =userRepository.findByusername("aasim");
        assertTrue(!user.getJournalEntries().isEmpty());
    }
}
