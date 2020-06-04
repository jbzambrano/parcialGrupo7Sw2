package com.example.parcial.repository;

import com.example.parcial.entity.Producto;
import com.example.parcial.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

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



}
