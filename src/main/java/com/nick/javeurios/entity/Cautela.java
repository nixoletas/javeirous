package com.nick.javeurios.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tb_cautela")
public class Cautela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "militar_id")
    @JsonIgnore
    private Militar militar;

    @ManyToOne
    @JoinColumn(name = "carga_id")
    @JsonIgnore
    private Carga carga;

    @Column(name = "data_cautela")
    private LocalDateTime dataCautela;

    @Column(name = "data_devolucao")
    private LocalDateTime dataDevolucao;
}
