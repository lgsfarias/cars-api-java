package com.carsapi.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carsapi.api.dto.CarsDTO;

@RestController
@RequestMapping("/api/cars")
public class CarController {

  @PostMapping
  public String create(@RequestBody CarsDTO req) {
    System.out.println("modelo: " + req.modelo() +
        "\nfabricante: " + req.fabricante() +
        "\ndataFabricacao: " + req.dataFabricacao() +
        "\nvalor: " + req.valor() +
        "\nanoModelo: " + req.anoModelo());
    return "Car created";
  }
}
