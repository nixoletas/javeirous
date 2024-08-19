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

}
