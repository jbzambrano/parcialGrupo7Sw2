package com.example.parcial.repository;

import com.example.parcial.dto.cantidadProductosDto;
import com.example.parcial.dto.productosDto;
import com.example.parcial.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String> {

    @Query(value = "SELECT * FROM parcial.producto WHERE nombre LIKE ?1% OR codigo LIKE ?2%", nativeQuery = true)
    List<Producto> buscarProductosPorInicioDeNombreOId(String nombre, String codigo);

    @Query(value="SELECT nombre, cantidadVendido FROM parcial.producto", nativeQuery=true)
    List<cantidadProductosDto> cantiProductosVend ();

    @Query(value="SELECT codigo, nombre, precioUnitario, descripcion, stock, cantidadVendido, (stock- cantidadVendido) as valides \n" +
            "FROM parcial.producto \n" +
            "GROUP BY codigo\n" +
            "ORDER BY valides ASC\n" +
            "LIMIT 1", nativeQuery=true)
    List <productosDto> productMasVendido();

    @Query(value="SELECT codigo, nombre, precioUnitario, descripcion, stock, cantidadVendido, (stock- cantidadVendido) as valides \n" +
            "FROM parcial.producto \n" +
            "GROUP BY codigo\n" +
            "ORDER BY valides DESC\n" +
            "LIMIT 1", nativeQuery=true)
    List<productosDto> productMenosVendido();

    @Query(value="SELECT * FROM parcial.producto ORDER BY precioUnitario DESC LIMIT 1", nativeQuery= true)
    List<Producto> productMasCaro();






}
