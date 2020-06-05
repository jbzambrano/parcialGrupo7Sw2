package com.example.parcial.repository;

import com.example.parcial.dto.UsuarioOligarcaDto;
import com.example.parcial.entity.Producto;
import com.example.parcial.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


    public Usuario findByCorreo(String correo);




    @Query(value = "select * from usuario where idRol = ?1",
            nativeQuery = true)
    List<Usuario> listaGestores(Integer idrol);



    @Query(value = "select * from usuario where nombre = ?1",
            nativeQuery = true)
    List<Usuario> buscarGestor(String nombre);


    @Query(value="SELECT * FROM usuario u" +
            "WHERE correo=?1", nativeQuery = true)
    List <Usuario> obtenerCorreo (String correo);

    @Query (value="call guardarRegistrados(?1, ?2, ?3, ?4,?5)", nativeQuery=true)
    List <Usuario> guardarRegistrados(Integer dni, String nombre,String apellido,String correo,String password);


    @Query (value="SELECT max(sumita) AS \"maximo\",dni FROM (SELECT sum(pxc.subtotal) AS \"sumita\", c.dni FROM parcial.productoxcarrito pxc, parcial.carrito c, parcial.pago pag WHERE pxc.idCarrito = c.idCarrito AND pag.idCarrito = c.idCarrito GROUP BY c.dni) es", nativeQuery=true)
    List <UsuarioOligarcaDto> usuarioOligarcaDto();




}
