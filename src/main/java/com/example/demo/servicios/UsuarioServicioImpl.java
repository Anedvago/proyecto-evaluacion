package com.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Usuario;
import com.example.demo.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{
	
	@Autowired
	private UsuarioRepositorio repo;

	@Override
	public List<Usuario> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<Usuario> findByID(Long id) {
		return repo.findById(id);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return repo.save(usuario);
	}

	@Override
	public void deleteByID(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<Usuario> buscarPorNombre(Usuario detUsuario) {
		return repo.buscarPorUsuario(detUsuario.getNombre());
	}

	

	

}
