package com.espe.examen.examentercerparcial.services;

import com.espe.examen.examentercerparcial.dto.PolizaRequestDto;
import com.espe.examen.examentercerparcial.modelentities.Poliza;
import java.util.List;

public interface PolizaService {

    Poliza emitir(PolizaRequestDto dto);

    List<Poliza> listar();

    Poliza cancelar(Long id);
}