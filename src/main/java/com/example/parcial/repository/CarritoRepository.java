package com.example.parcial.repository;

import com.example.parcial.dto.ElementosCarritoPorPedazoDeNombreDto;
import com.example.parcial.dto.ElementosDelCarritoDto;
import com.example.parcial.dto.comprasCarritoDto;
import com.example.parcial.dto.facturasDto;
import com.example.parcial.entity.Carrito;
import com.example.parcial.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Integer> {


    @Query(value="SELECT sum(total) as facturatotal FROM parcial.carrito", nativeQuery=true)
    List<facturasDto> totalFacturado();


    @Query(value="SELECT pxc.idProductoxCarrito, pxc.codigo AS \"cod\", pxc.cantidad, pxc.subtotal, p.nombre AS \"nom\", p.precioUnitario, p.descripcion, p.stock AS \"st\", p.foto2 FROM parcial.productoxcarrito pxc, parcial.producto p WHERE pxc.codigo = p.codigo AND pxc.idCarrito = ?1", nativeQuery=true)
    List<ElementosDelCarritoDto> elementosDelCarritoDto(Integer idCarrito);


    @Query(value="SELECT pxc.idProductoxCarrito, pxc.codigo AS \"cod\", pxc.cantidad, pxc.subtotal, p.nombre AS \"nom\", p.precioUnitario, p.descripcion, p.stock AS \"st\", p.foto2 FROM parcial.productoxcarrito pxc, parcial.producto p WHERE pxc.codigo = p.codigo AND pxc.idCarrito = ?1 AND p.nombre LIKE %?2%", nativeQuery=true)
    List<ElementosCarritoPorPedazoDeNombreDto> elementosCarritoPorPedazoDeNombreDto(Integer idCarrito,String nombre);

    @Query(value="SELECT  sum(subtotal) AS \"suma\" FROM parcial.productoxcarrito pxc, parcial.producto p WHERE pxc.codigo = p.codigo AND pxc.idCarrito = ?1", nativeQuery=true)
    Double totalCarritoDto(Integer idCarrito);


}
