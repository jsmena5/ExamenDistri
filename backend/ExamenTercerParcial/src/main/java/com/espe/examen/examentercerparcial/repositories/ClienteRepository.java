package com.espe.examen.examentercerparcial.repositories;

import com.espe.examen.examentercerparcial.modelentities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
