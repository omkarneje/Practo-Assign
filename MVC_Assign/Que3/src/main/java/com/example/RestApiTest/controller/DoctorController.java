// src/main/java/com/example/demo/controller/DoctorController.java
package com.example.RestApiTest.controller;

import com.example.RestApiTest.model.Doctor;
import com.example.RestApiTest.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    private final ApplicationContext applicationContext;

    @Autowired
    public DoctorController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @GetMapping("/{id}")
    public String getDoctorById(@PathVariable Long id, Model model) {
        DoctorService doctorService = applicationContext.getBean(DoctorService.class);
        Optional<Doctor> doctor = doctorService.getDoctorById(id);
        System.out.println(doctor);
        if (doctor.isPresent()) {
            model.addAttribute("doctor", doctor.get());
            return "doctorDetail";
        } else {
            return "errorView";
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Long> addDoctor(@RequestBody Doctor doctor) {
        DoctorService doctorService = applicationContext.getBean(DoctorService.class);
        Doctor savedDoctor = doctorService.addDoctor(doctor);

        return ResponseEntity.ok(savedDoctor.getId());
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        DoctorService doctorService = applicationContext.getBean(DoctorService.class);
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}

