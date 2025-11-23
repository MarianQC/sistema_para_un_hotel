package com.hotel.sistemahotel.repositorio;

import com.hotel.sistemahotel.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {
    
    Usuario findByCorreo(String correo);
    boolean existsByCorreo(String correo);
    boolean existsByCedula(String cedula);
}