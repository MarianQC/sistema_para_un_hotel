package com.hotel.sistemahotel.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado {
    
    @Id
    @Column(length = 10)
    private String cedula;
    
    @Column(length = 50, nullable = false)
    private String nombre;
    
    @Column(length = 50, nullable = false)
    private String apellido;
    
    @Column(length = 100, unique = true, nullable = false)
    private String correo;
    
    @Column(length = 30, unique = true, nullable = false)
    private String usuario;
    
    @Column(length = 100, nullable = false)
    private String contrasena;
    
    @Column(length = 20, nullable = false)
    private String rol;
    
    // Constructor vacío
    public Empleado() {}
    
    // Constructor con parámetros
    public Empleado(String cedula, String nombre, String apellido, String correo,
                    String usuario, String contrasena, String rol) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    // Getters y Setters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}