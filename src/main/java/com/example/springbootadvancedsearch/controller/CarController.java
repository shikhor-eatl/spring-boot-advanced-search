package com.example.springbootadvancedsearch.controller;

import com.example.springbootadvancedsearch.model.Car;
import com.example.springbootadvancedsearch.repository.CarRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/cars")
    public Object searchForCars(@SearchSpec Specification<Car> specs) {
        return carRepository.findAll(Specification.where(specs));
    }
}
