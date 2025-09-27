package com.example.laboratorio520220229.controller;

import com.example.laboratorio520220229.repository.RankingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ranking")
public class RankingController {

    private final RankingRepository rankingRepository;

    public RankingController(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }

    @GetMapping
    public String mostrarRanking(Model model) {
        model.addAttribute("ranking", rankingRepository.obtenerRankingUsuarios());
        return "ranking/lista";
    }
}
