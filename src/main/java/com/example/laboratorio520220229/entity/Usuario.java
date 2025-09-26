package com.example.laboratorio520220229.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="usuarios")
@Getter @Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="correo")
    private String correo;

    @Column(name="edad")
    private int edad;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="contrasena")
    private String contrasena;
}
