package com.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Detalle;
import com.example.demo.modelo.ReporteProd;
import com.example.demo.repositorio.DetalleRepositorio;


@Service
public class DetalleServicioImpl implements DetalleServicio{
	
	@Autowired
	private DetalleRepositorio repo;

	@Override
	public List<Detalle> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<Detalle> findByID(Long id) {
		return repo.findById(id);
	}

	@Override
	public Detalle save(Detalle detalle) {
		return repo.save(detalle);
	}

	@Override
	public void deleteByID(Long id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<?> obtenerReporte() {
		return repo.obtenerReporte();
	}

	

}
