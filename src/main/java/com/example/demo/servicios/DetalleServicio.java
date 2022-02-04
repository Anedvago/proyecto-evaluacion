package com.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Detalle;
import com.example.demo.modelo.ReporteProd;


public interface DetalleServicio {
	public List<Detalle> findAll();
	
	public Optional<Detalle> findByID(Long id);
	
	public List<?> obtenerReporte();
	
	public Detalle save(Detalle detalle);
	
	public void deleteByID(Long id);
}
