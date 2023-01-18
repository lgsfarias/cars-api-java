package com.carsapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carsapi.api.dto.CarsDTO;
import com.carsapi.api.model.Car;
import com.carsapi.api.repository.CarRepository;

@RestController
@RequestMapping("/api/cars")
public class CarController {

  @Autowired
  private CarRepository repository;

  @GetMapping
  public List<Car> listAll() {
    return repository.findAll();
  }

  @PostMapping
  public String create(@RequestBody CarsDTO req) {
    System.out.println("modelo: " + req.modelo() +
        "\nfabricante: " + req.fabricante() +
        "\ndataFabricacao: " + req.dataFabricacao() +
        "\nvalor: " + req.valor() +
        "\nanoModelo: " + req.anoModelo());

    repository.save(new Car(req));
    return "Car created";
  }
}
