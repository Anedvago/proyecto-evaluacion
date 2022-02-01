package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Detalle;

@Repository
public interface DetalleRepositorio extends JpaRepository<Detalle, Long>{

}
