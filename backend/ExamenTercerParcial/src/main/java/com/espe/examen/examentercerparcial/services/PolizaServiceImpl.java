package com.espe.examen.examentercerparcial.services;

import com.espe.examen.examentercerparcial.dto.PolizaRequestDto;
import com.espe.examen.examentercerparcial.modelentities.Cliente;
import com.espe.examen.examentercerparcial.modelentities.PlanSeguro;
import com.espe.examen.examentercerparcial.modelentities.Poliza;
import com.espe.examen.examentercerparcial.repositories.ClienteRepository;
import com.espe.examen.examentercerparcial.repositories.PlanSeguroRepository;
import com.espe.examen.examentercerparcial.repositories.PolizaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolizaServiceImpl implements PolizaService {

    @Autowired
    private PolizaRepository polizaRepo;

    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private PlanSeguroRepository planRepo;

    @Override
    public Poliza emitir(PolizaRequestDto dto) {

        Cliente cliente = clienteRepo.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no existe"));

        PlanSeguro plan = planRepo.findById(dto.getPlanSeguroId())
                .orElseThrow(() -> new RuntimeException("Plan no existe"));

        Poliza poliza = new Poliza();
        poliza.setNumeroPoliza("POL-" + System.currentTimeMillis());
        poliza.setFechaInicio(dto.getFechaInicio());
        poliza.setFechaFin(dto.getFechaFin());
        poliza.setPrimaMensual(plan.getPrimaBase());
        poliza.setEstado("ACTIVA");
        poliza.setCliente(cliente);
        poliza.setPlanSeguro(plan);

        return polizaRepo.save(poliza);
    }

    @Override
    public List<Poliza> listar() {
        return polizaRepo.findAll();
    }

    @Override
    public Poliza cancelar(Long id) {
        Poliza poliza = polizaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Póliza no encontrada"));
        poliza.setEstado("CANCELADA");
        return polizaRepo.save(poliza);
    }
}