package com.hariSolution.producer;


import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Service
public class MessageProducer {

    private final KafkaTemplate<String, EmployeeDetails> kafkaTemplate;

    public MessageProducer(KafkaTemplate<String, EmployeeDetails> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(EmployeeDetails employeeDetails) {
        Message<EmployeeDetails> message= MessageBuilder
                .withPayload(employeeDetails)
                .setHeader(TOPIC,"employee-topic").build();

        kafkaTemplate.send("employee-topic", message.getPayload());
        System.out.println("Sent Employee Details: " + employeeDetails);
    }



}
