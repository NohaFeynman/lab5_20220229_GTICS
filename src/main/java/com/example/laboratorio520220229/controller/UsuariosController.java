package com.example.laboratorio520220229.controller;

import com.example.laboratorio520220229.entity.Usuario;
import com.example.laboratorio520220229.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    private final UsuarioRepository usuarioRepository;

    public UsuariosController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/nuevo")
    public String nuevoUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        return "usuarios/form";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@Valid Usuario usuario,
                                 BindingResult bindingResult,
                                 RedirectAttributes attr,
                                 Model model){

        // Validaciones por anotaciones
        if (bindingResult.hasErrors()){
            model.addAttribute("usuario", usuario);
            return "usuarios/form";
        }

        if (usuarioRepository.findByCorreo(usuario.getCorreo()).isPresent()){
            bindingResult.rejectValue("correo", "correo.duplicado", "Ya existe un usuario con ese correo");
            model.addAttribute("usuario", usuario);
            return "usuarios/form";
        }

        usuarioRepository.save(usuario);
        attr.addFlashAttribute("msg","Usuario registrado correctamente");
        return "redirect:/principal";
    }
}
