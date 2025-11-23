package com.hotel.sistemahotel.controlador;

import com.hotel.sistemahotel.modelo.Empleado;
import com.hotel.sistemahotel.servicio.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/empleados")
@CrossOrigin(origins = "*")
public class EmpleadoControlador {
    
    @Autowired
    private EmpleadoServicio empleadoServicio;
    
    // LOGIN EMPLEADO
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginEmpleado(@RequestBody Map<String, String> datos) {
        String usuario = datos.get("usuario");
        String contrasena = datos.get("contrasena");
        
        Empleado empleado = empleadoServicio.iniciarSesion(usuario, contrasena);
        Map<String, Object> respuesta = new HashMap<>();
        
        if (empleado != null) {
            Map<String, String> empleadoData = new HashMap<>();
            empleadoData.put("cedula", empleado.getCedula());
            empleadoData.put("nombre", empleado.getNombre());
            empleadoData.put("apellido", empleado.getApellido());
            empleadoData.put("correo", empleado.getCorreo());
            empleadoData.put("usuario", empleado.getUsuario());
            empleadoData.put("rol", empleado.getRol());
            
            respuesta.put("exito", true);
            respuesta.put("mensaje", "Login exitoso");
            respuesta.put("empleado", empleadoData);
        } else {
            respuesta.put("exito", false);
            respuesta.put("mensaje", "Usuario o contraseña incorrectos");
        }
        
        return ResponseEntity.ok(respuesta);
    }
    
    // ENVIAR CÓDIGO DE RECUPERACIÓN
    @PostMapping("/recuperar/enviar")
    public ResponseEntity<Map<String, String>> enviarCodigo(@RequestBody Map<String, String> datos) {
        String correo = datos.get("correo");
        String resultado = empleadoServicio.enviarCodigoRecuperacion(correo);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", resultado);
        return ResponseEntity.ok(respuesta);
    }
    
    // CAMBIAR CONTRASEÑA
    @PostMapping("/recuperar/cambiar")
    public ResponseEntity<Map<String, String>> cambiarContrasena(@RequestBody Map<String, String> datos) {
        String correo = datos.get("correo");
        String codigo = datos.get("codigo");
        String nuevaContrasena = datos.get("nuevaContrasena");
        
        String resultado = empleadoServicio.cambiarContrasena(correo, codigo, nuevaContrasena);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", resultado);
        return ResponseEntity.ok(respuesta);
    }
}