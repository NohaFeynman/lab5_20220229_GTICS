package com.example.laboratorio520220229.controller;

import com.example.laboratorio520220229.entity.Mensaje;
import com.example.laboratorio520220229.entity.Usuario;
import com.example.laboratorio520220229.repository.MensajeRepository;
import com.example.laboratorio520220229.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/mensajes")
public class MensajesController {

    private final MensajeRepository mensajeRepository;
    private final UsuarioRepository usuarioRepository;

    public MensajesController(MensajeRepository mensajeRepository, UsuarioRepository usuarioRepository) {
        this.mensajeRepository = mensajeRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/nuevo")
    public String nuevoMensaje(Model model) {
        model.addAttribute("mensaje", new Mensaje());

        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);

        return "mensajes/form";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Mensaje mensaje,
                          BindingResult bindingResult,
                          RedirectAttributes attr,
                          Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("usuarios", usuarioRepository.findAll());
            return "mensajes/form";
        }

        mensaje.setFechaEnvio(new Timestamp(System.currentTimeMillis()));

        try {
            mensajeRepository.save(mensaje);
            attr.addFlashAttribute("msgExito", "Mensaje enviado exitosamente");
        } catch (Exception e) {
            attr.addFlashAttribute("msgError", "No se pudo enviar el mensaje");
        }

        return "redirect:/mensajes/nuevo";
    }

    @GetMapping("/recibidos/{usuarioId}")
    public String verRecibidos(@PathVariable("usuarioId") Integer usuarioId, Model model) {
        List<Mensaje> recibidos = mensajeRepository.findMensajesByDestinatario(usuarioId);
        model.addAttribute("mensajes", recibidos);
        model.addAttribute("total", recibidos.size());
        return "mensajes/recibidos";
    }
}
