package com.espe.examen.examentercerparcial.modelentities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "poliza")
public class Poliza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String numeroPoliza;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    private BigDecimal primaMensual;

    private String estado; // ACTIVA / CANCELADA

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private PlanSeguro planSeguro;

    // getters y setters

    public Poliza(Long id, String numeroPoliza, LocalDate fechaInicio, BigDecimal primaMensual, LocalDate fechaFin, String estado, PlanSeguro planSeguro, Cliente cliente) {
        this.id = id;
        this.numeroPoliza = numeroPoliza;
        this.fechaInicio = fechaInicio;
        this.primaMensual = primaMensual;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.planSeguro = planSeguro;
        this.cliente = cliente;
    }

    public Poliza() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public BigDecimal getPrimaMensual() {
        return primaMensual;
    }

    public void setPrimaMensual(BigDecimal primaMensual) {
        this.primaMensual = primaMensual;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public PlanSeguro getPlanSeguro() {
        return planSeguro;
    }

    public void setPlanSeguro(PlanSeguro planSeguro) {
        this.planSeguro = planSeguro;
    }
}