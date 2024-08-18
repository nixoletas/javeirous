package com.nick.javeurios.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@Table(name = "tb_carga")
public class CargaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patrimonio;
    private String descricao;
    private String boletim;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "militar_id")
    @JsonIgnore
    private MilitarEntity militarEntity;

}
