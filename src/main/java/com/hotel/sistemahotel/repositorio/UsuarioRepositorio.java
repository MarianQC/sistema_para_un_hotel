package com.hotel.sistemahotel.repositorio;

import com.hotel.sistemahotel.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UsuarioRepositorio extends JpaRepository<Usuario, String>{
  
    // Aquí puedes agregar consultas personalizadas si lo necesitas
    // Ejemplo: List<Usuario> findByApellido(String apellido);
}

    

