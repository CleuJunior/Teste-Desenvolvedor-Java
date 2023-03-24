package com.automobilefleet.repositories;

import com.automobilefleet.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByAvailable(Boolean available);
    List<Car> findCarsByBrand_Name(String name);
}