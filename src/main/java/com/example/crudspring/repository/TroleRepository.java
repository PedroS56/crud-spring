package com.example.crudspring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crudspring.models.Trole;

public interface TroleRepository extends JpaRepository<Trole, Integer> {
    List<Trole> findByNombreContaining(String nombre);
}