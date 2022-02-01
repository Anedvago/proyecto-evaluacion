package com.example.demo.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.modelo.Producto;
import com.example.demo.repositorio.ProductoRepositorio;

@Service
public class ProductoServicioImpl implements ProductoServicio{
	
	@Autowired
	private ProductoRepositorio repo;

	@Override
	public List<Producto> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<Producto> findByID(Long id) {
		return repo.findById(id);
	}

	@Override
	public Producto save(Producto producto) {
		return repo.save(producto);
	}

	@Override
	public void deleteByID(Long id) {
		repo.deleteById(id);
		
	}

}
