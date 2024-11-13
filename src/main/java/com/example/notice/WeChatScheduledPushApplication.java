package com.example.notice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WeChatScheduledPushApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeChatScheduledPushApplication.class, args);
    }

}
