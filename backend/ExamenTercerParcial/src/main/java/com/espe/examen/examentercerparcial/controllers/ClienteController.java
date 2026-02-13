package com.espe.examen.examentercerparcial.controllers;

import com.espe.examen.examentercerparcial.modelentities.Cliente;
import com.espe.examen.examentercerparcial.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public Cliente crear(@RequestBody Cliente c) {
        return service.crear(c);
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Cliente obtener(@PathVariable Long id) {
        return service.listar()
                .stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable Long id, @RequestBody Cliente c) {
        return service.actualizar(id, c);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}