package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.TipoIdentificacion;
import com.example.demo.repositorio.TipoIdenRepositorio;

@Service
public class TipoIdenServicioImpl implements TipoIdenServicio {
	
	@Autowired
	private TipoIdenRepositorio repo;

	@Override
	public List<TipoIdentificacion> findAll() {
		return repo.findAll();
	}

}
