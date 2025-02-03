package com.hariSolution.consumer;

import com.hariSolution.consumer.EmployeeDetails;
import com.hariSolution.employee.Employee;
import com.hariSolution.mapper.EmployeeMapper;
import com.hariSolution.repository.ConsumerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageConsumer {
    private final ConsumerRepository repository;
    private final EmployeeMapper employeeMapper;

    @KafkaListener(topics = "employee-topic", groupId = "employeeGroup", containerFactory = "kafkaListenerContainerFactory")
    public void receivedMessage(EmployeeDetails employeeDetails) {

        Employee employee= this.repository.save(this.employeeMapper.toEmployee(employeeDetails));

        System.out.println(employee);

        System.out.println("Received Employee Details: " + employeeDetails);
    }
}
