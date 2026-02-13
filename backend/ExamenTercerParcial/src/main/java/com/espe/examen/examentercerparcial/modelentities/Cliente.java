package com.espe.examen.examentercerparcial.modelentities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombres;

    @NotBlank
    @Column(unique = true)
    private String identificacion;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String telefono;

    // getters y setters


    public Cliente(Long id, String nombres, String identificacion, String email, String telefono) {
        this.id = id;
        this.nombres = nombres;
        this.identificacion = identificacion;
        this.email = email;
        this.telefono = telefono;
    }

    public Cliente() {

    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}