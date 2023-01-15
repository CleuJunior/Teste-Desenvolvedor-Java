package com.automobilefleet.api.controllers;

import com.automobilefleet.api.reponse.CarImageResponse;
import com.automobilefleet.api.reponse.CarResponse;
import com.automobilefleet.api.request.CarImageRequest;
import com.automobilefleet.services.CarImageService;
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
@RequestMapping(value = "/api/v1/car-images")
@RequiredArgsConstructor
public class CarImageController {

    private final CarImageService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CarImageResponse> getCarImageById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getImageById(id));
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<CarImageResponse>> listOfCarImages() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listAllImage());
    }

    @PostMapping(value = "/save")
    public ResponseEntity<CarImageResponse> saveImage(@RequestBody CarImageRequest request) {
        CarImageResponse response = service.saveCarImage(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<CarImageResponse> updateCarImage(@PathVariable Long id, @RequestBody CarImageRequest request) {
        CarImageResponse response = service.updateCarImage(id, request);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<CarResponse> deleteCar(@PathVariable Long id) {
        service.deleteCarImage(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}