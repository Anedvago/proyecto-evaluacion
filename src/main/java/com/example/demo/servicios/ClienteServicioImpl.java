package com.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Cliente;
import com.example.demo.repositorio.ClienteRepositorio;

@Service
public class ClienteServicioImpl implements ClienteServicio{
	
	@Autowired
	private ClienteRepositorio repo;

	@Override
	public List<Cliente> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<Cliente> findByID(Long id) {
		return repo.findById(id);
	}

	@Override
	public Cliente save(Cliente cliente) {
		return repo.save(cliente);
	}

	@Override
	public void deleteByID(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<Cliente> buscarPorIden(long tipo, String iden) {
		return repo.buscarPorIden(tipo, iden);
	}

}
