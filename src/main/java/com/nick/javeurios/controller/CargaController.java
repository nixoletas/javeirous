package com.nick.javeurios.controller;

import com.nick.javeurios.entity.Carga;
import com.nick.javeurios.enums.Status;
import com.nick.javeurios.repository.CargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carga")
public class CargaController {

    @Autowired
    private CargaRepository cargaRepository;

    @GetMapping
    public List<Carga> findAll(){
        return cargaRepository.findAll();
    }

    @PostMapping
    public Carga create(@RequestBody Carga carga){
        validateStatus(carga.getStatus());
        return cargaRepository.save(carga);
    }

    @PutMapping("/{id}")
    public Carga update(@PathVariable("id") Long id, @RequestBody Carga carga) {
        if (cargaRepository.existsById(id)) {
            validateStatus(carga.getStatus());
            carga.setId(id);
            return cargaRepository.save(carga);
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
