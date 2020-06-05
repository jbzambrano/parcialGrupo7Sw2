package com.example.parcial.repository;

import com.example.parcial.entity.Producto;
import com.example.parcial.entity.Productoxcarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface ProductoxcarritoRepository extends JpaRepository<Productoxcarrito, Integer> {

    @Query(value = "SELECT * FROM parcial.productoxcarrito WHERE codigo = ?1 AND idCarrito = ?2", nativeQuery = true)
    List<Productoxcarrito> verificarSiYaTengoElProductoEnElCarrito(String codigo, Integer idCarrito);


}
