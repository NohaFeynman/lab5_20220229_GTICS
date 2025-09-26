package com.example.laboratorio520220229.repository;

import com.example.laboratorio520220229.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}
