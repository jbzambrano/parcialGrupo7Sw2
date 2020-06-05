package com.example.parcial.repository;


import com.example.parcial.dto.comprasCarritoDto;
import com.example.parcial.entity.Pago;
import com.example.parcial.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {

    @Query(value="SELECT count(idPago) as cantidadcompras FROM parcial.pago", nativeQuery=true)
    List<comprasCarritoDto> cantidadComprasRealizadas();


    @Query(value="SELECT * FROM parcial.pago WHERE dni=?1", nativeQuery=true)
    List<Pago> obtenerPorDni(Integer dni);


}
