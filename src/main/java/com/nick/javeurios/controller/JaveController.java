package com.nick.javeurios.controller;

import com.nick.javeurios.entity.CargaEntity;
import com.nick.javeurios.entity.Status;
import com.nick.javeurios.repository.CargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carga")
public class JaveController {

    @Autowired
    private CargaRepository cargaRepository;

    @GetMapping
    public List<CargaEntity> findAll(){
        return cargaRepository.findAll();
    }

    @PostMapping
    public CargaEntity create(@RequestBody CargaEntity cargaEntity){
        validateStatus(cargaEntity.getStatus());
        return cargaRepository.save(cargaEntity);
    }

    @PutMapping("/{id}")
    public CargaEntity update(@PathVariable("id") Long id, @RequestBody CargaEntity cargaEntity) {
        if (cargaRepository.existsById(id)) {
            validateStatus(cargaEntity.getStatus());
            cargaEntity.setId(id);
            return cargaRepository.save(cargaEntity);
        } else {
            throw new RuntimeException("not found");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        if (cargaRepository.existsById(id)) {
            cargaRepository.deleteById(id);
        } else {
            throw new RuntimeException("not found");
        }
    }

    private void validateStatus(Status status) {
        if (status == null) {
            throw new IllegalArgumentException("Status não pode ser nulo.");
        }
        // Optionally, add more validation logic here if needed
    }
}
