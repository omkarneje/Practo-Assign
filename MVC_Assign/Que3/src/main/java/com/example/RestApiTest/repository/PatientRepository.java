// src/main/java/com/example/demo/repository/PatientRepository.java
package com.example.RestApiTest.repository;

import com.example.RestApiTest.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}

