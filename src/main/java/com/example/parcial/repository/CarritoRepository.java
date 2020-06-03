package com.example.parcial.repository;

import com.example.parcial.entity.Carrito;
import com.example.parcial.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Integer> {

}
