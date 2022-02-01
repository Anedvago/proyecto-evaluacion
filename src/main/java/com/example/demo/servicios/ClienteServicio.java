package com.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Cliente;

public interface ClienteServicio {
	
	public List<Cliente> findAll();
	
	public Optional<Cliente> findByID(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void deleteByID(Long id);

}
