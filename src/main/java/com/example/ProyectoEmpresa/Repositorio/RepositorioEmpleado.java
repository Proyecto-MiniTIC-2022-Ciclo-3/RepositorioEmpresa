package com.example.ProyectoEmpresa.Repositorio;

import com.example.ProyectoEmpresa.Entidades.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmpleado extends JpaRepository<Empleados, Long> {
}
