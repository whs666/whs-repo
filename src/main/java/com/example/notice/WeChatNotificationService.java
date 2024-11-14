package com.example.notice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class WeChatNotificationService {

    private static final RestTemplate restTemplate = new RestTemplate();

    @Value("${wxpusher.token}")
    private String appToken;

    @Value("${wxpusher.uid}")
    private String uid;

    @Scheduled(cron = "0 * * * * ?")
    public void sendWeChatNotification() {
        try {
            String url = "http://wxpusher.zjiecode.com/api/send/message";

            Map<String, Object> request = new HashMap<>();
            request.put("appToken", appToken);
            request.put("content", "亲爱的，已经很晚了，请注意休息，早点睡觉对身体好！ 🌙");
            request.put("contentType", 1);
            request.put("uids", new String[]{uid});

            String response = restTemplate.postForObject(url, request, String.class);

            System.out.println("通知发送成功: " + LocalDateTime.now());
            System.out.println("API 响应: " + response);
        } catch (Exception e) {
            System.err.println("发送通知失败: " + e.getMessage());
        }
    }
}