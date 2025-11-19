package com.hotel.sistemahotel.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Reseña {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReseña;

    @ManyToOne
    @JoinColumn(name = "cedula_cliente")
    private Usuario cliente;

    private String tipoDestino; // "Habitacion" o "Salon"
    private String comentario;
    private Integer calificacion;
    private LocalDate fechaReseña;

    /**
     * @return the idReseña
     */
    public Long getIdReseña() {
        return idReseña;
    }

    /**
     * @param idReseña the idReseña to set
     */
    public void setIdReseña(Long idReseña) {
        this.idReseña = idReseña;
    }

    /**
     * @return the cliente
     */
    public Usuario getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the tipoDestino
     */
    public String getTipoDestino() {
        return tipoDestino;
    }

    /**
     * @param tipoDestino the tipoDestino to set
     */
    public void setTipoDestino(String tipoDestino) {
        this.tipoDestino = tipoDestino;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return the calificacion
     */
    public Integer getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @return the fechaReseña
     */
    public LocalDate getFechaReseña() {
        return fechaReseña;
    }

    /**
     * @param fechaReseña the fechaReseña to set
     */
    public void setFechaReseña(LocalDate fechaReseña) {
        this.fechaReseña = fechaReseña;
    }
    
    
}
