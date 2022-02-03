package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.TipoIdentificacion;
import com.example.demo.modelo.Usuario;
import com.example.demo.servicios.TipoIdenServicio;

@RestController
@RequestMapping("/api/clientes/")
@CrossOrigin(origins = "http://localhost:4200/")
public class TipoIdenControlador {	
	
	@Autowired
	private TipoIdenServicio serv;
	
	
	// lista todos los tipos de identificaciones
		@GetMapping("/tipos-identificaciones")
		public List<TipoIdentificacion> listarTodos() {
			return serv.findAll();
		}
}
