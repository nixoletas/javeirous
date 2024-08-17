package com.nick.javeurios.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@Table(name = "tb_militar")
public class MilitarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Length(min = 10, max = 10)
    private String identidade;

    @NotNull
    @Pattern(regexp = "Cel|TC|Maj|Cap|1º Ten|2º Ten|Asp Of|ST|1º Sgt|2º Sgt|3º Sgt|Cb|Sd EP| Sd EV")
    private String pg;

    @NotNull
    @Length(max = 30)
    private String nome;

    @Pattern(regexp = "Cia Com|Cia GE|COGE|Cia C2|CCAp|EM|Almox|Saude|Garagem|Res Armto")
    private String subunidade;

    private String telefone;

}
