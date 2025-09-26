package com.example.laboratorio520220229.entity;

import jakarta.persistence.*;
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

    @Column(name="remitente_id")
    private Integer remitenteId;

    @Column(name="destinatario_id")
    private Integer destinatarioId;

    @Column(name="regalo_tipo")
    private String regaloTipo;

    @Column(name="regalo_color")
    private String regaloColor;

    @Column(name="contenido")
    private String contenido;

    @Column(name="fecha_envio")
    private Timestamp fechaEnvio;

}

