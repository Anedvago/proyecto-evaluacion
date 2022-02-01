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

import com.example.demo.modelo.Usuario;
import com.example.demo.servicios.UsuarioServicio;

@RestController
@RequestMapping("/api/usuarios/")
public class UsuarioControlador {
	
	@Autowired
	private UsuarioServicio serv;
	
	// lista todos los usuarios
	@GetMapping("/usuarios")
	public List<Usuario> listarTodosUsuarios() {
		return serv.findAll();
	}

	// crea un nuevo Usuario
	@PostMapping("/registro-usuarios")
	public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(serv.save(usuario));
	}

	// Obtener un Usuario
	@GetMapping("/usuario/{id}")
	public ResponseEntity<?> obtenerUsuario(@PathVariable Long id) {
		Optional<Usuario> usuario = serv.findByID(id);

		if (!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(usuario);
	}

	// actualizar Usuario
	@PutMapping("/usuario/{id}")
	public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuarioNuevo, @PathVariable Long id) {
		Optional<Usuario> usuario = serv.findByID(id);

		if (!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		usuario.get().setApellido(usuarioNuevo.getApellido());
		usuario.get().setContraseña(usuarioNuevo.getContraseña());
		usuario.get().setNombre(usuarioNuevo.getNombre());
		usuario.get().setUsuario(usuarioNuevo.getUsuario());

		return ResponseEntity.status(HttpStatus.CREATED).body(serv.save(usuario.get()));
	}

	// Eliminar Usuario
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {

		Optional<Usuario> usuario = serv.findByID(id);

		if (!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		serv.deleteByID(id);
		return ResponseEntity.ok().build();
	}

}
