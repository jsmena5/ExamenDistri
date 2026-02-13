package com.espe.examen.examentercerparcial.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class PolizaRequestDto {

    @NotNull
    private Long clienteId;

    @NotNull
    private Long planSeguroId;

    @NotNull
    private LocalDate fechaInicio;

    @NotNull
    private LocalDate fechaFin;

    // getters y setters

    public PolizaRequestDto(Long planSeguroId, Long clienteId, LocalDate fechaInicio, LocalDate fechaFin) {
        this.planSeguroId = planSeguroId;
        this.clienteId = clienteId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getPlanSeguroId() {
        return planSeguroId;
    }

    public void setPlanSeguroId(Long planSeguroId) {
        this.planSeguroId = planSeguroId;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}