package com.example.parcial.repository;

import com.example.parcial.entity.Producto;
import com.example.parcial.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
