package com.example.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Perfil;
import com.example.demo.servicios.PerfilServicio;



@RestController
@RequestMapping("/api/perfiles/")
public class PerfilControlador {
	
	@Autowired
	private PerfilServicio serv;
	
	// lista todos los Perfiles
		@GetMapping("/perfiles")
		public List<Perfil> listarTodosPerfiles() {
			return serv.findAll();
		}

		// crea un nuevo Perfil
		@PostMapping("/registro-perfiles")
		public ResponseEntity<Perfil> crearPerfil(@RequestBody Perfil perfil) {
			return ResponseEntity.status(HttpStatus.CREATED).body(serv.save(perfil));
		}

		// Obtener un Perfil
		@GetMapping("/perfil/{id}")
		public ResponseEntity<?> obtenerPerfil(@PathVariable Long id) {
			Optional<Perfil> perfil = serv.findByID(id);

			if (!perfil.isPresent()) {
				return ResponseEntity.notFound().build();
			}

			return ResponseEntity.ok(perfil);
		}

		// actualizar Perfil
		@PutMapping("/perfil/{id}")
		public ResponseEntity<?> actualizarPerfil(@RequestBody Perfil perfilNuevo, @PathVariable Long id) {
			Optional<Perfil> perfil = serv.findByID(id);

			if (!perfil.isPresent()) {
				return ResponseEntity.notFound().build();
			}

			perfil.get().setNombre(perfilNuevo.getNombre());

			return ResponseEntity.status(HttpStatus.CREATED).body(serv.save(perfil.get()));
		}

		// Eliminar Perfil
		@DeleteMapping("/perfil/{id}")
		public ResponseEntity<?> eliminarPerfil(@PathVariable Long id) {

			Optional<Perfil> perfil = serv.findByID(id);

			if (perfil.isPresent()) {
				return ResponseEntity.notFound().build();
			}

			serv.deleteByID(id);
			return ResponseEntity.ok().build();
		}
	
}
