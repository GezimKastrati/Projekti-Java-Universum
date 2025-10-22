package com.backend.testManagement.controller;

import com.backend.testManagement.dto.TestDTOSave;
import com.backend.testManagement.services.TestService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/data")
public class DataController {
    
    @Autowired
    private TestService testService;

    @PostMapping("/seed")
    @ApiResponse(responseCode = "200", description = "Sample data created successfully")
    public ResponseEntity<String> seedData() {
        testService.saveTest(new TestDTOSave("Gezim", "Studentovic"));
        testService.saveTest(new TestDTOSave("Ana", "Testovic"));
        testService.saveTest(new TestDTOSave("Marko", "Sampleovic"));
        return ResponseEntity.ok("Sample data created - Personalized by Student");
    }
}