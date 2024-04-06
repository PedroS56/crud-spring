package com.example.crudspring.models;

import jakarta.persistence.*;

@Entity
@Table(name = "trole")
public class Trole {
    public Trole() {
    }

    public Trole(String nombre) {
        this.nombre = nombre;
    }

    public Trole(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}