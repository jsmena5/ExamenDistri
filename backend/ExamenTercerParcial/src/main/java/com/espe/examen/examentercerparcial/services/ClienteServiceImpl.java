package com.espe.examen.examentercerparcial.services;

import com.espe.examen.examentercerparcial.modelentities.Cliente;
import com.espe.examen.examentercerparcial.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepo;

    @Override
    public Cliente crear(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    @Override
    public List<Cliente> listar() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente actualizar(Long id, Cliente cliente) {
        return clienteRepo.findById(id).map(c -> {
            c.setNombres(cliente.getNombres());
            c.setIdentificacion(cliente.getIdentificacion());
            c.setEmail(cliente.getEmail());
            c.setTelefono(cliente.getTelefono());
            return clienteRepo.save(c);
        }).orElseThrow();
    }

    @Override
    public void eliminar(Long id) {
        clienteRepo.deleteById(id);
    }
}