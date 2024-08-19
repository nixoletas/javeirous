package com.nick.javeurios.controller;

import com.nick.javeurios.entity.Carga;
import com.nick.javeurios.entity.Cautela;
import com.nick.javeurios.entity.Militar;
import com.nick.javeurios.enums.Status;
import com.nick.javeurios.repository.CargaRepository;
import com.nick.javeurios.repository.CautelaRepository;
import com.nick.javeurios.repository.MilitarRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/militares")
public class MilitarController {

    @Autowired
    private MilitarRepository militarRepository;

    @Autowired
    private CargaRepository cargaRepository;

    @Autowired
    private CautelaRepository cautelaRepository;

    @GetMapping
    public List<Militar> findAll(){
        return militarRepository.findAll();
    }

    @PostMapping
    public Militar create(@RequestBody @Valid Militar militar){
        return militarRepository.save(militar);
    }

    @PutMapping("/{id}")
    public Militar update(@PathVariable("id") Long id, @RequestBody @NotNull @Positive Militar militar) {
        if (militarRepository.existsById(id)) {
            militar.setId(id);
            return militarRepository.save(militar);
        } else {
            throw new RuntimeException("not found");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") @NotNull @Positive Long id) {
        if (militarRepository.existsById(id)) {
            militarRepository.deleteById(id);
        } else {
            throw new RuntimeException("not found");
        }
    }

    @PostMapping("/{militarId}/cautelar/{cargaId}")
    public Militar cautelarMaterial(
            @PathVariable("militarId") @NotNull @Positive Long militarId,
            @PathVariable("cargaId") @NotNull @Positive Long cargaId) {

        Militar militar = militarRepository.findById(militarId)
                .orElseThrow(() -> new RuntimeException("Militar não encontrado"));

        Carga carga = cargaRepository.findById(cargaId)
                .orElseThrow(() -> new RuntimeException("Material não encontrado"));

        if (Status.DISPONIVEL.equals(carga.getStatus())) {
            // Criação de uma nova cautela
            Cautela cautela = new Cautela();
            cautela.setMilitar(militar);
            cautela.setCarga(carga);
            cautela.setDataCautela(LocalDateTime.now());
            cautelaRepository.save(cautela);

            // Atualiza o status do material
            carga.setStatus(Status.CAUTELADO);
            cargaRepository.save(carga);

            return militar;
        } else {
            throw new RuntimeException("Material já está cautelado");
        }
    }

    @PostMapping("/{militarId}/descautelar/{cargaId}")
    public Militar devolverMaterial(
            @PathVariable("militarId") @NotNull @Positive Long militarId,
            @PathVariable("cargaId") @NotNull @Positive Long cargaId) {

        Militar militar = militarRepository.findById(militarId)
                .orElseThrow(() -> new RuntimeException("Militar não encontrado"));

        Carga carga = cargaRepository.findById(cargaId)
                .orElseThrow(() -> new RuntimeException("Material não encontrado"));

        Cautela cautela = cautelaRepository.findByMilitarAndCarga(militar, carga)
                .orElseThrow(() -> new RuntimeException("Cautela não encontrada"));

        if (Status.CAUTELADO.equals(carga.getStatus())) {
            // Registra a data de devolução
            cautela.setDataDevolucao(LocalDateTime.now());
            cautelaRepository.save(cautela);

            // Atualiza o status do material
            carga.setStatus(Status.DISPONIVEL);
            cargaRepository.save(carga);

            return militar;
        } else {
            throw new RuntimeException("Material não está cautelado");
        }
    }

}
