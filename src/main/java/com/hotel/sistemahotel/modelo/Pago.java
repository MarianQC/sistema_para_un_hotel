package com.hotel.sistemahotel.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private ReservaHabitaciones reservaHabitaciones;

    private Double subtotal;
    private Double iva;
    private Double total;
    private String metodoPago;
    private LocalDate fechaPago;
    private String estadoPago;
    private String serviciosExtra;

    /**
     * @return the idPago
     */
    public Long getIdPago() {
        return idPago;
    }

    /**
     * @param idPago the idPago to set
     */
    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    /**
     * @return the reservaHabitaciones
     */
    public ReservaHabitaciones getReservaHabitaciones() {
        return reservaHabitaciones;
    }

    /**
     * @param reservaHabitaciones the reservaHabitaciones to set
     */
    public void setReservaHabitaciones(ReservaHabitaciones reservaHabitaciones) {
        this.reservaHabitaciones = reservaHabitaciones;
    }

    /**
     * @return the subtotal
     */
    public Double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the iva
     */
    public Double getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(Double iva) {
        this.iva = iva;
    }

    /**
     * @return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * @return the metodoPago
     */
    public String getMetodoPago() {
        return metodoPago;
    }

    /**
     * @param metodoPago the metodoPago to set
     */
    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    /**
     * @return the fechaPago
     */
    public LocalDate getFechaPago() {
        return fechaPago;
    }

    /**
     * @param fechaPago the fechaPago to set
     */
    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    /**
     * @return the estadoPago
     */
    public String getEstadoPago() {
        return estadoPago;
    }

    /**
     * @param estadoPago the estadoPago to set
     */
    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    /**
     * @return the serviciosExtra
     */
    public String getServiciosExtra() {
        return serviciosExtra;
    }

    /**
     * @param serviciosExtra the serviciosExtra to set
     */
    public void setServiciosExtra(String serviciosExtra) {
        this.serviciosExtra = serviciosExtra;
    }
    
    
}
