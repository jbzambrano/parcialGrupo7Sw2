package com.example.parcial.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{

    @Id
    @Digits(integer=8,fraction=0,message="El parámetro ha ingresar debe de tener 8 digitos numéricos")
    @Min(0)
    @Max(99999999)
    private Integer dni;
    @Max(value=3)
    @Min(value=1)
    private Integer idrol;
    @Size(max=20,message= "Este campo no puede tener más de 20 caracteres")
    @NotBlank(message="Este campo no puede estar vacio")
    private String nombre;
    @Size(max=20,message= "Este campo no puede tener más de 20 caracteres")
    @NotBlank(message="Este campo no puede estar vacio")
    private String apellido;
    @Email(message="Please provide a valid email address")
    private String correo;
    private String password;
    private Integer activo;

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }
}
