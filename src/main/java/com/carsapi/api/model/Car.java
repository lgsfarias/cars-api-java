package com.carsapi.api.model;

import com.carsapi.api.dto.CarsDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 50, nullable = false)
  private String modelo;

  @Column(length = 50, nullable = false)
  private String fabricante;

  @Column(length = 50, nullable = false)
  private String dataFabricacao;

  @Column(nullable = false)
  private Double valor;

  @Column(nullable = false)
  private Integer anoModelo;

  public Car(CarsDTO dto) {
    this.modelo = dto.modelo();
    this.fabricante = dto.fabricante();
    this.dataFabricacao = dto.dataFabricacao();
    this.valor = dto.valor();
    this.anoModelo = dto.anoModelo();

  }
}
