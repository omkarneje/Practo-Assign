package org.example.service;

import org.example.dto.MessageDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AwsService {

    @Value("${aws.region}")
    private String region;

    @Value("${localstack.endpoint}")
    private String localstackEndpoint;

    private SnsClient snsClient;
    private SqsClient sqsClient;
    private final String emailQueueUrl = "http://localhost:4566/000000000000/emailQueue";
    private final String smsQueueUrl = "http://localhost:4566/000000000000/smsQueue";
    private final String entityQueueUrl = "http://localhost:4566/000000000000/entityQueue";

    @PostConstruct
    public void init() {
        snsClient = SnsClient.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("accessKey", "secretKey")))
                .endpointOverride(URI.create(localstackEndpoint))
                .build();

        sqsClient = SqsClient.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("accessKey", "secretKey")))
                .endpointOverride(URI.create(localstackEndpoint))
                .build();
    }

    public void publishMessage(String message, String eventType) {
        String snsTopicArn = "arn:aws:sns:us-east-1:000000000000:appointment";
        PublishRequest publishRequest = PublishRequest.builder()
                .topicArn(snsTopicArn)
                .message(message)
                .messageAttributes(Map.of(
                        "eventType", software.amazon.awssdk.services.sns.model.MessageAttributeValue.builder().dataType("String").stringValue(eventType).build()
                ))
                .build();

        PublishResponse publishResponse = snsClient.publish(publishRequest);
        System.out.println("MessageId: " + publishResponse.messageId());
    }

    public List<MessageDto> receiveMessages(String queueUrl) {
        System.out.println("Receiving messages from queue: " + queueUrl);
        ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
                .queueUrl(queueUrl)
                .maxNumberOfMessages(10)
                .build();

        List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).messages();
        System.out.println("Received messages: " + messages);

        return messages.stream()
                .map(msg -> new MessageDto(msg.messageId(), msg.body()))
                .collect(Collectors.toList());
    }
}
