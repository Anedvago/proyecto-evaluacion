package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.TipoIdentificacion;

public interface TipoIdenRepositorio extends JpaRepository<TipoIdentificacion, Long> {

}
