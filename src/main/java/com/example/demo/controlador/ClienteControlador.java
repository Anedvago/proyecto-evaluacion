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

import com.example.demo.modelo.Cliente;
import com.example.demo.servicios.ClienteServicio;

@RestController
@RequestMapping("/api/clientes/")
public class ClienteControlador {

	@Autowired
	private ClienteServicio servicioCliente;

	// lista todos los clientes
	@GetMapping("/clientes")
	public List<Cliente> listarTodosClientes() {
		return servicioCliente.findAll();
	}

	// crea un nuevo cliente
	@PostMapping("/registro-clientes")
	public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(servicioCliente.save(cliente));
	}

	// Obtener un cliente
	@GetMapping("/cliente/{id}")
	public ResponseEntity<?> obtenerCliente(@PathVariable Long id) {
		Optional<Cliente> cliente = servicioCliente.findByID(id);

		if (!cliente.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(cliente);
	}

	// actualizar usuario
	@PutMapping("/cliente/{id}")
	public ResponseEntity<?> actualizarCliente(@RequestBody Cliente clienteNuevo, @PathVariable Long id) {
		Optional<Cliente> cliente = servicioCliente.findByID(id);

		if (!cliente.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		cliente.get().setEstado(clienteNuevo.getEstado());
		cliente.get().setFechaRegistro(clienteNuevo.getFechaRegistro());
		cliente.get().setIdentificacion(clienteNuevo.getIdentificacion());
		cliente.get().setRazonSocial(clienteNuevo.getRazonSocial());
		cliente.get().setTipoIdentificacion(clienteNuevo.getTipoIdentificacion());

		return ResponseEntity.status(HttpStatus.CREATED).body(servicioCliente.save(cliente.get()));
	}

	// Eliminar usuario
	@DeleteMapping("/cliente/{id}")
	public ResponseEntity<?> eliminarCliente(@PathVariable Long id) {

		Optional<Cliente> cliente = servicioCliente.findByID(id);

		if (!cliente.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		servicioCliente.deleteByID(id);
		return ResponseEntity.ok().build();
	}

}
