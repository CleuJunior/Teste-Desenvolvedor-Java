package com.automobilefleet.api.controllers;

import com.automobilefleet.api.reponse.RentalResponse;
import com.automobilefleet.api.request.RentalRequest;
import com.automobilefleet.services.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/rental")
@RequiredArgsConstructor
public class RentalController {
    private final RentalService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<RentalResponse> getRentalById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getRental(id));
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<RentalResponse>> listOfRental() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listOfRental());
    }

    @PostMapping(value = "/save")
    public ResponseEntity<RentalResponse> saveRental(@RequestBody RentalRequest request) {
        RentalResponse response = service.saveRental(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<RentalResponse> updateBrand(@PathVariable Long id, @RequestBody RentalRequest request) {
        RentalResponse response = service.updateRental(id, request);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<RentalResponse> deleteBrand(@PathVariable Long id) {
        service.deleteRental(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}