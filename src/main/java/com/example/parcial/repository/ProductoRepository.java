package com.example.parcial.repository;

import com.example.parcial.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String> {

    @Query(value = "SELECT * FROM parcial.producto WHERE nombre LIKE ?1% OR codigo LIKE ?2%", nativeQuery = true)
    List<Producto> buscarProductosPorInicioDeNombreOId(String nombre, String codigo);

}
