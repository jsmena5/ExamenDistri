package com.espe.examen.examentercerparcial.services;

import com.espe.examen.examentercerparcial.modelentities.Cliente;
import java.util.List;

public interface ClienteService {

    Cliente crear(Cliente cliente);

    List<Cliente> listar();

    Cliente actualizar(Long id, Cliente cliente);

    void eliminar(Long id);
}