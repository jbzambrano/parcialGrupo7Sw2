package com.example.parcial.entity;


import javax.persistence.*;

@Entity
@Table(name="carrito")
public class Carrito {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcarrito;
    private Double total;
    private Integer dni;

    public Integer getIdcarrito() {
        return idcarrito;
    }

    public void setIdcarrito(Integer idcarrito) {
        this.idcarrito = idcarrito;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }
}
