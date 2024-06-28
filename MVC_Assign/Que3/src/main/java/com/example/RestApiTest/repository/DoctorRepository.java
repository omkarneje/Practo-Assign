// src/main/java/com/example/demo/repository/DoctorRepository.java
package com.example.RestApiTest.repository;

import com.example.RestApiTest.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
