package com.sringproject.springbackendapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
class SpringBackendApiApplicationTests {

    @Test
    void contextLoads() {
        assertTrue(true);
    }

}
