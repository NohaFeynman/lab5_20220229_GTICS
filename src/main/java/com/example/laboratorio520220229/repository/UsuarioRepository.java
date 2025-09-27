package com.example.laboratorio520220229.repository;

import com.example.laboratorio520220229.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByCorreo(String correo);
}