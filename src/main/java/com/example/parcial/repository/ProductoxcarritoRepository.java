package com.example.parcial.repository;

import com.example.parcial.entity.Producto;
import com.example.parcial.entity.Productoxcarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoxcarritoRepository extends JpaRepository<Productoxcarrito, Integer> {

}
