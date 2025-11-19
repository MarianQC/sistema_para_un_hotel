package com.hotel.sistemahotel.controlador;

import com.hotel.sistemahotel.modelo.Usuario;
import com.hotel.sistemahotel.repositorio.UsuarioRepositorio;
import java.util.List;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/usuarios")

public class UsuarioControlador {
   

    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioControlador(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    // ✅ GET: Listar todos los usuarios
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    // ✅ POST: Crear un nuevo usuario
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }
}


