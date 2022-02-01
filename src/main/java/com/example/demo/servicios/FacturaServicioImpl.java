package com.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Factura;
import com.example.demo.repositorio.FacturaRepositorio;

@Service
public class FacturaServicioImpl implements FacturaServicio{
	
	@Autowired
	private FacturaRepositorio repo;

	@Override
	public List<Factura> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<Factura> findByID(Long id) {
		return repo.findById(id);
	}

	@Override
	public Factura save(Factura factura) {
		return repo.save(factura);
	}

	@Override
	public void deleteByID(Long id) {
		repo.deleteById(id);
		
	}

}
