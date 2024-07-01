package org.example.controller;

import org.example.dto.MessageDto;
import org.example.service.AwsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AwsController {

    @Autowired
    private AwsService awsService;

    @PostMapping("/publish/{eventType}")
    public void publishMessage(@RequestBody String message, @PathVariable String eventType) {
        awsService.publishMessage(message, eventType);
    }

    @GetMapping("/consumer/email")
    public List<MessageDto> consumeEmailMessages() {
        return awsService.receiveMessages("http://localhost:4566/000000000000/emailQueue");
    }

    @GetMapping("/consumer/sms")
    public List<MessageDto> consumeSmsMessages() {
        return awsService.receiveMessages("http://localhost:4566/000000000000/smsQueue");
    }

    @GetMapping("/consumer/entity")
    public List<MessageDto> consumeEntityMessages() {
        return awsService.receiveMessages("http://localhost:4566/000000000000/entityQueue");
    }
}
