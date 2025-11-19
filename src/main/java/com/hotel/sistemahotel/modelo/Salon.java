package com.hotel.sistemahotel.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSalon;

    private String nombre;
    private Integer capacidad;
    private Double precioHora;
    private String estado;

    /**
     * @return the idSalon
     */
    public Long getIdSalon() {
        return idSalon;
    }

    /**
     * @param idSalon the idSalon to set
     */
    public void setIdSalon(Long idSalon) {
        this.idSalon = idSalon;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the capacidad
     */
    public Integer getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * @return the precioHora
     */
    public Double getPrecioHora() {
        return precioHora;
    }

    /**
     * @param precioHora the precioHora to set
     */
    public void setPrecioHora(Double precioHora) {
        this.precioHora = precioHora;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}

