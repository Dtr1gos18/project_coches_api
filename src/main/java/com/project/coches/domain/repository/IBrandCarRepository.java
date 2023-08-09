package com.project.coches.domain.repository;

import com.project.coches.domain.pojo.BrandCarPojo;

import java.util.List;
import java.util.Optional;

public interface IBrandCarRepository {

    /**
     * Develve una lista con todas las marcas de coches
     * @return lista con marcas de coches
     */
    List<BrandCarPojo> getAll();

    /**
     * Devuelve una marca de coche dado su id, se usa para el uso de los nulos e impedir que el programa se rompa
     * @param id de marca coche
     * @return Optional del marca de coche encontrado
     */
    Optional<BrandCarPojo> getBrandCar(Integer id);

    /**
     * Guarda una nueva marca coche
     * @param newBrandCar marca coche a guarda
     * @return marca coche guardada
     */
    BrandCarPojo save(BrandCarPojo newBrandCar);

    /**
     * Elimina una marca coche dado su id
     * @param idBrandCar id de la marca coche a eliminar
     */
    void delete(Integer idBrandCar);
}
