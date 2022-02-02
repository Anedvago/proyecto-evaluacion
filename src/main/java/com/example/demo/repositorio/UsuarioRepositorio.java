package com.example.demo.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
	
	@Query(nativeQuery = false, value = "SELECT u FROM Usuario u WHERE nombre = :nombre")
	Optional<Usuario> buscarPorUsuario(@Param("nombre")String nombre);
	
}
