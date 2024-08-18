package com.nick.javeurios.controller;

import com.nick.javeurios.entity.CargaEntity;
import com.nick.javeurios.entity.MilitarEntity;
import com.nick.javeurios.entity.Status;
import com.nick.javeurios.repository.CargaRepository;
import com.nick.javeurios.repository.MilitarRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Validated
@RestController
@RequestMapping("/api/militares")
public class MilitarController {

    @Autowired
    private MilitarRepository militarRepository;

    @Autowired
    private CargaRepository cargaRepository;

    @GetMapping
    public List<MilitarEntity> findAll(){
        return militarRepository.findAll();
    }

    @PostMapping
    public MilitarEntity create(@RequestBody @Valid MilitarEntity militarEntity){
        return militarRepository.save(militarEntity);
    }

    @PutMapping("/{id}")
    public MilitarEntity update(@PathVariable("id") Long id, @RequestBody @NotNull @Positive MilitarEntity militarEntity) {
        if (militarRepository.existsById(id)) {
            militarEntity.setId(id);
            return militarRepository.save(militarEntity);
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

    //Cautelar material
    @PostMapping("/{militarId}/cautelar/{cargaId}")
    public MilitarEntity cautelarMaterial(
            @PathVariable("militarId") @NotNull @Positive Long militarId,
            @PathVariable("cargaId") @NotNull @Positive Long cargaId) {

        MilitarEntity militar = militarRepository.findById(militarId)
                .orElseThrow(() -> new RuntimeException("Militar não encontrado"));

        CargaEntity carga = cargaRepository.findById(cargaId)
                .orElseThrow(() -> new RuntimeException("Material não encontrado"));

        if (Status.DISPONIVEL.equals(carga.getStatus())) {
            System.out.println(carga.getStatus());
            carga.setStatus(Status.CAUTELADO);
            carga.setMilitarEntity(militar);
            cargaRepository.save(carga);

            return militar;
        } else {
            throw new RuntimeException("Material já está cautelado");
        }
    }
}
