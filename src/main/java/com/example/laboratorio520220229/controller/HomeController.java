package com.example.laboratorio520220229.controller;
import com.example.laboratorio520220229.repository.MensajeRepository;
import com.example.laboratorio520220229.repository.RankingRepository;
import com.example.laboratorio520220229.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
//@RequestMapping(value = "/")
public class HomeController {

    final UsuarioRepository usuarioRepository;
    final RankingRepository rankingRepository;
    final MensajeRepository mensajeRepository;

    public HomeController(UsuarioRepository usuarioRepository,  RankingRepository rankingRepository, MensajeRepository mensajeRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rankingRepository = rankingRepository;
        this.mensajeRepository = mensajeRepository;
    }

    @GetMapping(value = {"/principal", "/"})
    public String home(Model model){
        model.addAttribute("listaUsuarios", usuarioRepository.findAll());
        System.out.println("Se consigio relacion con la bd");

        return "home";

    }
}
