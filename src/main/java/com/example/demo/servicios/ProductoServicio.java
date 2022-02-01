package com.example.demo.servicios;

import java.util.List;
import java.util.Optional;
import com.example.demo.modelo.Producto;

public interface ProductoServicio {
	
	public List<Producto> findAll();
	
	public Optional<Producto> findByID(Long id);
	
	public Producto save(Producto producto);
	
	public void deleteByID(Long id);
}
