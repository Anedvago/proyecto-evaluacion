package com.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Usuario;

public interface UsuarioServicio {
	
	public List<Usuario> findAll();

	public Optional<Usuario> findByID(Long id);

	public Usuario save(Usuario usuario);

	public void deleteByID(Long id);
}
