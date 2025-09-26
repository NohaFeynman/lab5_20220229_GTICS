package com.example.laboratorio520220229.repository;

import com.example.laboratorio520220229.entity.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeRepository extends JpaRepository<Mensaje, Integer> {
}
