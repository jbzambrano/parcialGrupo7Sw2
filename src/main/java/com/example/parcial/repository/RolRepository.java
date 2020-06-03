package com.example.parcial.repository;

import com.example.parcial.entity.Producto;
import com.example.parcial.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
}
