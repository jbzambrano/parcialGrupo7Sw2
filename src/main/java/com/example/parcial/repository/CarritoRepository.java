package com.example.parcial.repository;

import com.example.parcial.dto.comprasCarritoDto;
import com.example.parcial.entity.Carrito;
import com.example.parcial.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Integer> {


    @Query(value="SELECT sum(total) as totalfacturado FROM parcial.carrito", nativeQuery=true)
    List<comprasCarritoDto> totalFacturado();





}
