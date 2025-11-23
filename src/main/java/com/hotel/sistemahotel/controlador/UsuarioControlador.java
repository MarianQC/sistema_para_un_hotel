package com.hotel.sistemahotel.controlador;

import com.hotel.sistemahotel.modelo.Usuario;
import com.hotel.sistemahotel.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioControlador {
    
    @Autowired
    private UsuarioServicio usuarioServicio;
    
    // REGISTRAR
    @PostMapping("/registrar")
    public ResponseEntity<Map<String, String>> registrar(@RequestBody Usuario usuario) {
        String resultado = usuarioServicio.registrarUsuario(usuario);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", resultado);
        return ResponseEntity.ok(respuesta);
    }
    
    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> datos) {
        String correo = datos.get("correo");
        String contraseña = datos.get("contraseña");
        
        Usuario usuario = usuarioServicio.iniciarSesion(correo, contraseña);
        Map<String, Object> respuesta = new HashMap<>();
        
        if (usuario != null) {
            Map<String, String> usuarioData = new HashMap<>();
            usuarioData.put("cedula", usuario.getCedula());
            usuarioData.put("nombre", usuario.getNombre());
            usuarioData.put("apellido", usuario.getApellido());
            usuarioData.put("correo", usuario.getCorreo());
            usuarioData.put("telefono", usuario.getTelefono());
            
            respuesta.put("exito", true);
            respuesta.put("mensaje", "Inicio de sesión exitoso");
            respuesta.put("usuario", usuarioData);
        } else {
            respuesta.put("exito", false);
            respuesta.put("mensaje", "Correo o contraseña incorrectos");
        }
        
        return ResponseEntity.ok(respuesta);
    }
    
    // ENVIAR CÓDIGO
    @PostMapping("/recuperar/enviar")
    public ResponseEntity<Map<String, String>> enviarCodigo(@RequestBody Map<String, String> datos) {
        String correo = datos.get("correo");
        String resultado = usuarioServicio.enviarCodigoRecuperacion(correo);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", resultado);
        return ResponseEntity.ok(respuesta);
    }
    
    // CAMBIAR CONTRASEÑA
    @PostMapping("/recuperar/cambiar")
    public ResponseEntity<Map<String, String>> cambiarContraseña(@RequestBody Map<String, String> datos) {
        String correo = datos.get("correo");
        String codigo = datos.get("codigo");
        String nuevaContraseña = datos.get("nuevaContraseña");
        
        String resultado = usuarioServicio.cambiarContraseña(correo, codigo, nuevaContraseña);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", resultado);
        return ResponseEntity.ok(respuesta);
    }
}