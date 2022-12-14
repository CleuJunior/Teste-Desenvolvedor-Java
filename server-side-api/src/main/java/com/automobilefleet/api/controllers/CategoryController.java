package com.automobilefleet.api.controllers;

import com.automobilefleet.api.reponse.CategoryResponse;
import com.automobilefleet.api.request.CategoryRequest;
import com.automobilefleet.services.CategoryService;
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
@RequestMapping(value = "/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getCategory(id));
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<CategoryResponse>> listOfBrand() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listCategories());
    }

    @PostMapping(value = "/save")
    public ResponseEntity<CategoryResponse> saveBrand(@RequestBody CategoryRequest request) {
        CategoryResponse response = service.saveCategory(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<CategoryResponse> updateBrand(@PathVariable Long id, @RequestBody CategoryRequest request) {
        CategoryResponse response = service.updateCategory(id, request);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<CategoryResponse> deleteBrand(@PathVariable Long id) {
        service.deleteCategory(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
