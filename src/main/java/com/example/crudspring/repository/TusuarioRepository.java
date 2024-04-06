package com.example.crudspring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crudspring.models.Tusuario;

public interface TusuarioRepository extends JpaRepository<Tusuario, Integer> {
    List<Tusuario> findByNombreContaining(String nombre);
}
