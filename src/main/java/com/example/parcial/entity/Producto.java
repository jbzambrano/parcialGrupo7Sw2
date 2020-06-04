package com.example.parcial.entity;


import javax.persistence.Column;
import java.sql.Blob;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="producto")
public class Producto {

    @Id
    @NotBlank
    @Size(max = 3)
    private String codigo;

    @NotBlank
    @Size(max = 40)
    private String nombre;

    @Digits(integer = 4, fraction = 2, message = "debe introducir un numero con un maximo de 4 enteros o 2 decimales")
    @Positive
    private Double preciounitario;

    @NotBlank
    @Size(max = 255)
    private String descripcion;

    @Digits(integer = 10, fraction = 0)
    @Positive
    private Integer stock;
    private String foto1;
    private String foto2;

    private Integer cantidadvendido;


    public Double getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(Double preciounitario) {
        this.preciounitario = preciounitario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getFoto1() {
        return foto1;
    }

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    public Integer getCantidadvendido() {
        return cantidadvendido;
    }

    public void setCantidadvendido(Integer cantidadvendido) {
        this.cantidadvendido = cantidadvendido;
    }
}
