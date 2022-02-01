package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Perfil;

@Repository
public interface PerfilRepositorio extends JpaRepository<Perfil, Long> {

}
