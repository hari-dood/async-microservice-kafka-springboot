package com.hariSolution.repository;

import com.hariSolution.employee.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends MongoRepository<Employee,String> {
}
