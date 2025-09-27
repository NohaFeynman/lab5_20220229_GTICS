package com.example.laboratorio520220229.repository;

import com.example.laboratorio520220229.entity.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface RankingRepository extends JpaRepository<Ranking,Integer> {
    @Query("SELECT u, COUNT(m.id) as totalRegalos " +
            "FROM Usuario u LEFT JOIN Mensaje m ON u.id = m.destinatarioId " +
            "GROUP BY u.id " +
            "ORDER BY totalRegalos DESC")
    List<Object[]> obtenerRankingUsuarios();
}
