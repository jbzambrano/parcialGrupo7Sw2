package com.example.parcial.entity;


import javax.persistence.*;

@Entity
@Table(name="productoxcarrito")
public class Productoxcarrito {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproductoxcarrito;
    private String codigo;
    private Integer idcarrito;
    private Integer cantidad;
    private Double subtotal;

    public Integer getIdproductoxcarrito() {
        return idproductoxcarrito;
    }

    public void setIdproductoxcarrito(Integer idproductoxcarrito) {
        this.idproductoxcarrito = idproductoxcarrito;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getIdcarrito() {
        return idcarrito;
    }

    public void setIdcarrito(Integer idcarrito) {
        this.idcarrito = idcarrito;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }



}
