package com.example.laboratorio520220229.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "mensajes")
@Getter
@Setter
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "El remitente es obligatorio")
    @Column(name = "remitente_id")
    private Integer remitenteId;

    @NotNull(message = "Debes escoger un destinatario")
    @Column(name = "destinatario_id")
    private Integer destinatarioId;

    @NotBlank(message = "Debes escoger el tipo de regalo")
    @Pattern(regexp = "(?i)^(FLOR|CARRITO)$",
            message = "El regalo debe ser FLOR o CARRITO")
    @Column(name = "regalo_tipo")
    private String regaloTipo;

    @NotBlank(message = "Debes indicar el color del regalo")
    @Column(name = "regalo_color")
    private String regaloColor;

    @NotBlank(message = "El mensaje no puede estar vacío")
    @Size(min = 20, message = "El mensaje debe tener al menos 20 caracteres")
    @Pattern(
            regexp = "^(?i)(?!.*\\bodio\\b)(?!.*\\bfeo\\b).*$",
            message = "El mensaje no debe contener las palabras \"odio\" ni \"feo\""
    )
    @Column(name = "contenido")
    private String contenido;

    @Column(name = "fecha_envio")
    private Timestamp fechaEnvio;
}
