package com.espe.examen.examentercerparcial.controllers;

import com.espe.examen.examentercerparcial.modelentities.PlanSeguro;
import com.espe.examen.examentercerparcial.services.PlanSeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/planes")
@CrossOrigin("*")
public class PlanSeguroController {

    @Autowired
    private PlanSeguroService service;

    @PostMapping
    public PlanSeguro crear(@RequestBody PlanSeguro p) {
        return service.crear(p);
    }

    @GetMapping
    public List<PlanSeguro> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public PlanSeguro obtener(@PathVariable Long id) {
        return service.listar()
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    @PutMapping("/{id}")
    public PlanSeguro actualizar(@PathVariable Long id, @RequestBody PlanSeguro p) {
        return service.actualizar(id, p);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}