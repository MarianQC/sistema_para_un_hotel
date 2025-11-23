package com.hotel.sistemahotel.servicio;

import com.hotel.sistemahotel.modelo.Empleado;
import com.hotel.sistemahotel.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmpleadoServicio {
    
    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;
    
    @Autowired
    private JavaMailSender mailSender;
    
    // Guardar códigos de recuperación temporalmente
    private final Map<String, String> codigosRecuperacion = new HashMap<>();
    
    // LOGIN (INICIAR SESIÓN)
    public Empleado iniciarSesion(String usuario, String contrasena) {
        Empleado empleado = empleadoRepositorio.findByUsuario(usuario);
        
        // Verificar que el empleado existe
        if (empleado == null) {
            return null;
        }
        
        // Verificar que la contraseña coincida
        if (empleado.getContrasena().equals(contrasena)) {
            return empleado;
        }
        
        return null;
    }
    
    // RECUPERAR CONTRASEÑA - Paso 1: Enviar código
    public String enviarCodigoRecuperacion(String correo) {
        Empleado empleado = empleadoRepositorio.findByCorreo(correo);
        
        if (empleado == null) {
            return "El correo no está registrado";
        }
        
        // Generar código aleatorio de 6 dígitos
        String codigo = String.format("%06d", (int)(Math.random() * 1000000));
        
        // Guardar código temporalmente
        codigosRecuperacion.put(correo, codigo);
        
        // Enviar correo
        try {
            SimpleMailMessage mensaje = new SimpleMailMessage();
            mensaje.setTo(correo);
            mensaje.setSubject("Recuperación de Contraseña - Sistema Hotel");
            mensaje.setText("Tu código de recuperación es: " + codigo + 
                          "\n\nEste código expirará en 10 minutos.");
            mailSender.send(mensaje);
            return "Código enviado al correo";
        } catch (MailException e) {
            return "Error al enviar el correo";
        }
    }
    
    // RECUPERAR CONTRASEÑA - Paso 2: Cambiar contraseña
    public String cambiarContrasena(String correo, String codigo, String nuevaContrasena) {
        // Verificar que el código sea correcto
        String codigoGuardado = codigosRecuperacion.get(correo);
        
        if (codigoGuardado == null || !codigoGuardado.equals(codigo)) {
            return "Código incorrecto o expirado";
        }
        
        // Buscar empleado
        Empleado empleado = empleadoRepositorio.findByCorreo(correo);
        if (empleado == null) {
            return "Empleado no encontrado";
        }
        
        // Cambiar contraseña
        empleado.setContrasena(nuevaContrasena);
        empleadoRepositorio.save(empleado);
        
        // Eliminar código usado
        codigosRecuperacion.remove(correo);
        
        return "Contraseña cambiada exitosamente";
    }
}