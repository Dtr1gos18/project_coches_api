package com.project.coches.controller;

import com.project.coches.domain.dto.BrandCarDto;
import com.project.coches.domain.useCase.IBrandCarUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador rest de marca coche
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/brands-cars")
public class BrandCarController {

    /**
     * servicio de marca coche
     */
    private final IBrandCarUseCase iBrandCarUseCase;

    /**
     * Devuelve lista de marca coches
     * @return HttpCode Ok con lista de marca coches
     */
    @GetMapping
    public ResponseEntity<List<BrandCarDto>> getAll(){
        return new ResponseEntity<>(iBrandCarUseCase.getAll(), HttpStatus.OK);
        //ResponseEntity.status(HttpStatus.OK).body(iBrandCarService.getAll()); segunda opcion
    }

    /**
     * Devuelve marca coche dado su id
     * @param id de la marca coche a buscar
     * @return HttpCode ok si la encuentra, HttpCode notFound de lo contrario
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<BrandCarDto> getBrandCar(@PathVariable Integer id){
        return  ResponseEntity.of(iBrandCarUseCase.getBrandCar(id));
    }

    /**
     * Crea una nueva marca coche
     * @param newBrandCarDto nueva marca coche a crear
     * @return HttpCode Created si la guarda correctamente, HttpCode BadRequest de lo contrario
     */
    @PostMapping
    public ResponseEntity<BrandCarDto> save(@RequestBody BrandCarDto newBrandCarDto){
        try{
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iBrandCarUseCase.save(newBrandCarDto));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    /**
     * Actualiza una marca coche
     * @param updateBrandCarDto marca coche actualizada
     * @return HttpCode Ok si la actualiza correctamente
     */
    @PatchMapping
    public ResponseEntity<BrandCarDto> update(@RequestBody BrandCarDto updateBrandCarDto){
        return ResponseEntity.of(iBrandCarUseCase.update(updateBrandCarDto));
    }

    /**
     * Elimina una marca coche
     * @param id de la marca coche a eliminar
     * @return HttpCode Ok si la elimina, HttpCode notFound si no existe
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iBrandCarUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
