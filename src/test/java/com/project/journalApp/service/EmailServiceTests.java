package com.project.journalApp.service;

import org.springframework.test.context.ActiveProfiles;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ActiveProfiles("dev")
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;

    @Test
    void testSendEmail() {
        emailService.sendEmail("aatifhasan00@gmail.com", "Mail from Journal App", "This is 3rd test mail from Journal App");
    }
}
