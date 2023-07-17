package com.example.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@Slf4j
public class ResourceController {

  @GetMapping("/api/resource")
  public ResponseEntity<String> getResource() {
    UUID requestId = UUID.randomUUID();

    LocalDateTime startTime = LocalDateTime.now();
    log.info("Received request. Request ID: {}. Start Time: {}", requestId, startTime);

    simulateProcessing();

    LocalDateTime endTime = LocalDateTime.now();
    long processingTime = java.time.Duration.between(startTime, endTime).toMillis();
    log.info("Processed request. Request ID: {}. End Time: {}. Processing Time: {} ms", requestId, endTime, processingTime);

    return ResponseEntity.ok("Resource Retrieved");
  }

  private void simulateProcessing() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
