package com.example.laboratorio520220229.entity;
import jakarta.validation.constraints.*;

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

    @NotBlank(message = "El nombre no puede estar vacio")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúñÑ ]+$", message = "Nombre solo puede contener letras y espacios")
    @Column(name="nombre")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacio")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúñÑ ]+$", message = "Apellido solo puede contener letras y espacios")
    @Column(name="apellido")
    private String apellido;

    @NotBlank(message = "El correo no puede estar vacio")
    @Email(message = "Formato no válido")
    @Column(name="correo")
    private String correo;

    @Min(value = 18, message = "Debes ser mayor o igual a 18")
    @Column(name="edad")
    private Integer edad;

    @NotBlank(message = "Descripción es obligatoria")
    @Size(min = 10, message = "La descripción debe tener al menos 10 caracteres")
    @Column(name="descripcion")
    private String descripcion;

    @NotBlank(message = "Contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    @Pattern(regexp = ".*\\d.*", message = "La contraseña debe contener al menos un dígito")
    @Column(name="contrasena")
    private String contrasena;
}
