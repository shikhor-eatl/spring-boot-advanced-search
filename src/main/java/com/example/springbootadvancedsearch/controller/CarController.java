package com.example.springbootadvancedsearch.controller;

import com.example.springbootadvancedsearch.model.Active;
import com.example.springbootadvancedsearch.model.Car;
import com.example.springbootadvancedsearch.model.Options;
import com.example.springbootadvancedsearch.repository.CarRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

@RestController
public class CarController {
    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/cars")
    public Object searchForCars(@SearchSpec Specification<Car> specs) {
        Object result = carRepository.findAll(Specification.where(specs));
        return result;
    }

    @PostMapping("/cars/add")
    public Object addCars() {
        Car car = new Car();
        Options options = new Options();
        Active active = new Active();
        active.setStatus("ACTIVE");

        car.setBrand("Zefer");
        car.setColor("Blue");
        car.setModel("Z-19");
        car.setCreationyear(2000);
        car.setIsDeleted(false);
        car.setPrice(10320334);

        options.setTransmission("T2019");
        options.setActive(active);
        options.setHasGPS("YES");
        car.setOptions(options);

        Object result = carRepository.save(car);
        return result;
    }

    @GetMapping("/custom-search/cars")
    public Object customSearchForCars(@SearchSpec Specification<Car> specs) {
        return carRepository.findAll(Specification.where(createSpecification("Toyota"))
                .and(specificationJoin("YUS")));
    }

    private Specification<Car> createSpecification(String brand) {
        return (Specification<Car>) (root, cq, cb) -> cb.equal(root.get("brand"), brand);
    }

    private Specification<Car> specificationJoin(String hasGPS) {
        return (Specification<Car>) (root, cq, cb) -> {
            Join join = root.join("options", JoinType.LEFT);
            return cb.equal(join.get("hasGPS"), hasGPS);
        };
    }
}
