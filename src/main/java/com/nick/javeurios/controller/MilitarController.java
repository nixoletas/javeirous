package com.nick.javeurios.controller;

import com.nick.javeurios.entity.CargaEntity;
import com.nick.javeurios.entity.MilitarEntity;
import com.nick.javeurios.repository.CargaRepository;
import com.nick.javeurios.repository.MilitarRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
}
