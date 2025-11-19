package com.hotel.sistemahotel.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Amenidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAmenidad;

    private String nombre;
    private String tipo;
    private Double precioExtra;

    /**
     * @return the idAmenidad
     */
    public Long getIdAmenidad() {
        return idAmenidad;
    }

    /**
     * @param idAmenidad the idAmenidad to set
     */
    public void setIdAmenidad(Long idAmenidad) {
        this.idAmenidad = idAmenidad;
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
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the precioExtra
     */
    public Double getPrecioExtra() {
        return precioExtra;
    }

    /**
     * @param precioExtra the precioExtra to set
     */
    public void setPrecioExtra(Double precioExtra) {
        this.precioExtra = precioExtra;
    }
    
    
}

