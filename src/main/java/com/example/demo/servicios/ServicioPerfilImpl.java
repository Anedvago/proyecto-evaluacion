package com.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Perfil;
import com.example.demo.repositorio.PerfilRepositorio;


@Service
public class ServicioPerfilImpl implements PerfilServicio{
	
	@Autowired
	private PerfilRepositorio repo;

	@Override
	public List<Perfil> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<Perfil> findByID(Long id) {
		return repo.findById(id);
	}

	@Override
	public Perfil save(Perfil perfil) {
		return repo.save(perfil);
	}

	@Override
	public void deleteByID(Long id) {
		repo.deleteById(id);
		
	}

}
