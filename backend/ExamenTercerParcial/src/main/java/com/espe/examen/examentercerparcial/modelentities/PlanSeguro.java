package com.espe.examen.examentercerparcial.modelentities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "plan_seguro")
public class PlanSeguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String tipo; // VIDA / AUTO / SALUD

    @NotNull
    private BigDecimal primaBase;

    @NotNull
    private BigDecimal coberturaMax;

    // getters y setters

    public PlanSeguro(Long id, BigDecimal primaBase, String nombre, String tipo, BigDecimal coberturaMax) {
        this.id = id;
        this.primaBase = primaBase;
        this.nombre = nombre;
        this.tipo = tipo;
        this.coberturaMax = coberturaMax;
    }

    public PlanSeguro() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrimaBase() {
        return primaBase;
    }

    public void setPrimaBase(BigDecimal primaBase) {
        this.primaBase = primaBase;
    }

    public BigDecimal getCoberturaMax() {
        return coberturaMax;
    }

    public void setCoberturaMax(BigDecimal coberturaMax) {
        this.coberturaMax = coberturaMax;
    }


}