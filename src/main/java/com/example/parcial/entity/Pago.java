package com.example.parcial.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="pago")
public class Pago {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpago;
    private Date fecha;
    private Integer tarjeta;
    @OneToOne
    @JoinColumn(name="idcarrito")
    private Carrito carrito;

    public Integer getIdpago() {
        return idpago;
    }

    public void setIdpago(Integer idpago) {
        this.idpago = idpago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Integer tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }
}
