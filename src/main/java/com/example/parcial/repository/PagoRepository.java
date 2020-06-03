package com.example.parcial.repository;


import com.example.parcial.entity.Pago;
import com.example.parcial.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {


}
