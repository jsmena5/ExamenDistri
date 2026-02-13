package com.espe.examen.examentercerparcial.services;

import com.espe.examen.examentercerparcial.modelentities.PlanSeguro;
import java.util.List;

public interface PlanSeguroService {

    PlanSeguro crear(PlanSeguro plan);

    List<PlanSeguro> listar();

    PlanSeguro actualizar(Long id, PlanSeguro plan);

    void eliminar(Long id);
}