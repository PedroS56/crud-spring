package com.example.crudspring.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tusuario")
public class Tusuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "nombre")
    String nombre;

    @Column(name = "a_paterno")
    String a_paterno;

    @Column(name = "a_materno")
    String a_materno;

    @Column(name = "id_trole")
    int id_trole;

    public Tusuario() {
    }

    public Tusuario(String nombre, String a_paterno, String a_materno, int id_trole) {
        this.nombre = nombre;
        this.a_paterno = a_paterno;
        this.a_materno = a_materno;
        this.id_trole = id_trole;
    }

    public Tusuario(int id, String nombre, String a_paterno, String a_materno, int id_trole) {
        this.id = id;
        this.nombre = nombre;
        this.a_paterno = a_paterno;
        this.a_materno = a_materno;
        this.id_trole = id_trole;
    }

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

    public String getA_paterno() {
        return a_paterno;
    }

    public void setA_paterno(String a_paterno) {
        this.a_paterno = a_paterno;
    }

    public String getA_materno() {
        return a_materno;
    }

    public void setA_materno(String a_materno) {
        this.a_materno = a_materno;
    }

    public int getId_trole() {
        return id_trole;
    }

    public void setId_trole(int id_trole) {
        this.id_trole = id_trole;
    }

}
