package com.example.parcial.repository;

import com.example.parcial.entity.Producto;
import com.example.parcial.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {



    @Query(value="SELECT * FROM usuario u" +
            "WHERE correo=?1", nativeQuery = true)
    List <Usuario> obtenerCorreo (String correo);

}
