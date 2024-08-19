package com.nick.javeurios.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nick.javeurios.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "tb_carga")
public class Carga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patrimonio;
    private String descricao;
    private String boletim;

    private String serie;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "militar_id")
    @JsonIgnore
    private Militar militar;

    private LocalDateTime dataCautela;

    @OneToMany(mappedBy = "carga")
    private List<Cautela> cautela;
}
