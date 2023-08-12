package com.project.coches.domain.useCase;

import com.project.coches.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ICarUseCase {

    List<CarDto> getAll();

    List<CarDto> getByIdBrandCar(Integer idBrandCar);

    List<CarDto> getCarByPriceLessThan(Double price);
    Optional<CarDto> getCar(Integer idCar);

    CarDto save(CarDto newCar);

    Boolean delete(Integer idCar);
}
