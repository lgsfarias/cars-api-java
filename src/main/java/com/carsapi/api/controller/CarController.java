package com.carsapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carsapi.api.dto.CarsDTO;
import com.carsapi.api.model.Car;
import com.carsapi.api.repository.CarRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cars")
public class CarController {

  @Autowired
  private CarRepository repository;

  @GetMapping
  public List<Car> listAll() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public Car findById(@PathVariable Long id) {
    return repository.findById(id).get();
  }

  @PostMapping
  public String create(@RequestBody @Valid CarsDTO req) {
    repository.save(new Car(req));
    return "Car created";
  }

  @PutMapping("/{id}")
  public String update(@PathVariable Long id, @RequestBody @Valid CarsDTO req) {
    repository.findById(id).map(car -> {
      car.setModelo(req.modelo());
      car.setFabricante(req.fabricante());
      car.setDataFabricacao(req.dataFabricacao());
      car.setValor(req.valor());
      car.setAnoModelo(req.anoModelo());
      return repository.save(car);
    });
    return "Car updated";
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Long id) {
    repository.deleteById(id);
    return "Car deleted";
  }
}
