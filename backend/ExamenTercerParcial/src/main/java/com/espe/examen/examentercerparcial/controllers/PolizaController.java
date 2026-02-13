package com.espe.examen.examentercerparcial.controllers;

import com.espe.examen.examentercerparcial.dto.PolizaRequestDto;
import com.espe.examen.examentercerparcial.modelentities.Poliza;
import com.espe.examen.examentercerparcial.services.PolizaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/polizas")
@CrossOrigin("*")
public class PolizaController {

    @Autowired
    private PolizaService polizaService;

    @PostMapping
    public Poliza emitir(@RequestBody @Valid PolizaRequestDto dto) {
        return polizaService.emitir(dto);
    }

    @GetMapping
    public List<Poliza> listar() {
        return polizaService.listar();
    }

    @GetMapping("/{id}")
    public Poliza obtener(@PathVariable Long id) {
        return polizaService.listar()
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    @PutMapping("/{id}/cancelar")
    public Poliza cancelar(@PathVariable Long id) {
        return polizaService.cancelar(id);
    }
}