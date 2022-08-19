package com.automobilefleet.api.controllers;

import com.automobilefleet.api.reponse.CostumerResponse;
import com.automobilefleet.api.request.CostumerRequest;
import com.automobilefleet.entities.Costumer;
import com.automobilefleet.services.CostumerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/costumer")
@AllArgsConstructor
public class CostumerController {
    private final CostumerService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CostumerResponse> getCostumerById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getCostumer(id));
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<CostumerResponse>> getCostumerById() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listCostumer());
    }

    @PostMapping(value = "/save")
    public ResponseEntity<CostumerResponse> saveCostumer(@RequestBody CostumerRequest request) {
        CostumerResponse response = service.saveCostumer(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
