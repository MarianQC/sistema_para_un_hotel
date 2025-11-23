package com.hotel.sistemahotel.repositorio;

import com.hotel.sistemahotel.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, String> {
    
    // Buscar empleado por usuario
    Empleado findByUsuario(String usuario);
    
    // Buscar empleado por correo
    Empleado findByCorreo(String correo);
    
    // Verificar si existe el usuario
    boolean existsByUsuario(String usuario);
    
    // Verificar si existe el correo
    boolean existsByCorreo(String correo);
    
    // Verificar si existe la cédula
    boolean existsByCedula(String cedula);
}