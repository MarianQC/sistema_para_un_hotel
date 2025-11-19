package com.hotel.sistemahotel.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class ReservaSalon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    @ManyToOne
    @JoinColumn(name = "cedula_cliente")
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(name = "id_salon")
    private Salon salon;

    private LocalDate fechaReserva;
    private Integer horasReservadas;
    private String estado;

    /**
     * @return the idReserva
     */
    public Long getIdReserva() {
        return idReserva;
    }

    /**
     * @param idReserva the idReserva to set
     */
    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
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
     * @return the salon
     */
    public Salon getSalon() {
        return salon;
    }

    /**
     * @param salon the salon to set
     */
    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    /**
     * @return the fechaReserva
     */
    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    /**
     * @param fechaReserva the fechaReserva to set
     */
    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    /**
     * @return the horasReservadas
     */
    public Integer getHorasReservadas() {
        return horasReservadas;
    }

    /**
     * @param horasReservadas the horasReservadas to set
     */
    public void setHorasReservadas(Integer horasReservadas) {
        this.horasReservadas = horasReservadas;
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
