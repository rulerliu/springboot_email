package com.example.email;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmailApplicationTests {

    @Autowired
    MailService mailService;

    @Test
    public void test2() {
        mailService.sendSimpleMail("liuwenqiang@shsnc.com", "subject", "content");
    }

}
