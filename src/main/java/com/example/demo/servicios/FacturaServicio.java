package com.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Factura;


public interface FacturaServicio {
	
	public List<Factura> findAll();
	
	public Optional<Factura> findByID(Long id);
	
	public Optional<Factura> obtenerUltFact();
	
	public Factura save(Factura factura);
	
	public void deleteByID(Long id);
}
