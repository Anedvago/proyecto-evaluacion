package com.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Perfil;



public interface PerfilServicio {
	public List<Perfil> findAll();
	
	public Optional<Perfil> findByID(Long id);
	
	public Perfil save(Perfil perfil);
	
	public void deleteByID(Long id);
}
