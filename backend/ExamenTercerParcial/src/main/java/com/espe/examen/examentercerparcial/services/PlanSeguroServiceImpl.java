package com.espe.examen.examentercerparcial.services;

import com.espe.examen.examentercerparcial.modelentities.PlanSeguro;
import com.espe.examen.examentercerparcial.repositories.PlanSeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanSeguroServiceImpl implements PlanSeguroService {

    @Autowired
    private PlanSeguroRepository planRepo;

    @Override
    public PlanSeguro crear(PlanSeguro plan) {
        return planRepo.save(plan);
    }

    @Override
    public List<PlanSeguro> listar() {
        return planRepo.findAll();
    }

    @Override
    public PlanSeguro actualizar(Long id, PlanSeguro plan) {
        return planRepo.findById(id).map(p -> {
            p.setNombre(plan.getNombre());
            p.setTipo(plan.getTipo());
            p.setPrimaBase(plan.getPrimaBase());
            p.setCoberturaMax(plan.getCoberturaMax());
            return planRepo.save(p);
        }).orElseThrow();
    }

    @Override
    public void eliminar(Long id) {
        planRepo.deleteById(id);
    }
}
