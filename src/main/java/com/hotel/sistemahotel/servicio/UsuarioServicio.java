package com.hotel.sistemahotel.servicio;

import com.hotel.sistemahotel.modelo.Usuario;
import com.hotel.sistemahotel.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.MailException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UsuarioServicio {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @Autowired
    private JavaMailSender mailSender;
    
    private final Map<String, String> codigosRecuperacion = new HashMap<>();
    
    // REGISTRAR USUARIO
    public String registrarUsuario(Usuario usuario) {
        try {
            if (usuarioRepositorio.existsByCorreo(usuario.getCorreo())) {
                return "El correo ya está registrado";
            }
            
            if (usuarioRepositorio.existsByCedula(usuario.getCedula())) {
                return "La cédula ya está registrada";
            }
            
            usuarioRepositorio.save(usuario);
            return "Usuario registrado exitosamente";
        } catch (Exception e) {
            return "Error al registrar usuario: " + e.getMessage();
        }
    }
    
    // LOGIN
    public Usuario iniciarSesion(String correo, String contraseña) {
        try {
            Usuario usuario = usuarioRepositorio.findByCorreo(correo);
            
            if (usuario == null) {
                return null;
            }
            
            if (usuario.getContraseña().equals(contraseña)) {
                return usuario;
            }
            
            return null;
        } catch (Exception e) {
            System.err.println("Error en iniciar sesión: " + e.getMessage());
            return null;
        }
    }
    
    // RECUPERAR CONTRASEÑA - Enviar código
    public String enviarCodigoRecuperacion(String correo) {
        try {
            Usuario usuario = usuarioRepositorio.findByCorreo(correo);
            
            if (usuario == null) {
                return "El correo no está registrado";
            }
            
            String codigo = String.format("%06d", (int)(Math.random() * 1000000));
            codigosRecuperacion.put(correo, codigo);
            
            SimpleMailMessage mensaje = new SimpleMailMessage();
            mensaje.setTo(correo);
            mensaje.setSubject("Recuperación de Contraseña - Hotel");
            mensaje.setText("Tu código de recuperación es: " + codigo + 
                          "\n\nEste código expirará en 10 minutos.");
            mailSender.send(mensaje);
            return "Código enviado al correo";
        } catch (MailException e) {
            return "Error al enviar el correo: " + e.getMessage();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
    
    // RECUPERAR CONTRASEÑA - Cambiar
    public String cambiarContraseña(String correo, String codigo, String nuevaContraseña) {
        try {
            String codigoGuardado = codigosRecuperacion.get(correo);
            
            if (codigoGuardado == null || !codigoGuardado.equals(codigo)) {
                return "Código incorrecto o expirado";
            }
            
            Usuario usuario = usuarioRepositorio.findByCorreo(correo);
            if (usuario == null) {
                return "Usuario no encontrado";
            }
            
            usuario.setContraseña(nuevaContraseña);
            usuarioRepositorio.save(usuario);
            codigosRecuperacion.remove(correo);
            
            return "Contraseña cambiada exitosamente";
        } catch (Exception e) {
            return "Error al cambiar contraseña: " + e.getMessage();
        }
    }
}