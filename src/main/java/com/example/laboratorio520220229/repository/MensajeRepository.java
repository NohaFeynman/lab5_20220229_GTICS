package com.example.laboratorio520220229.repository;

import com.example.laboratorio520220229.entity.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MensajeRepository extends JpaRepository<Mensaje, Integer> {
    @Query("SELECT m FROM Mensaje m WHERE m.destinatarioId = :usuarioId ORDER BY m.fechaEnvio DESC")
    List<Mensaje> findMensajesByDestinatario(Integer usuarioId);
}
