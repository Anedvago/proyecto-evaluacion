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

import com.example.demo.modelo.Factura;
import com.example.demo.servicios.FacturaServicio;

@RestController
@RequestMapping("/api/facturas/")
public class FacturaControlador {

	@Autowired
	private FacturaServicio serv;

	// lista todos las Facturas
	@GetMapping("/facturas")
	public List<Factura> listarTodasFacturas() {
		return serv.findAll();
	}

	// crea una nueva Factura
	@PostMapping("/registro-facturas")
	public ResponseEntity<Factura> crearFactura(@RequestBody Factura factura) {
		return ResponseEntity.status(HttpStatus.CREATED).body(serv.save(factura));
	}

	// Obtener una Factura
	@GetMapping("/factura/{id}")
	public ResponseEntity<?> obtenerFactura(@PathVariable Long id) {
		Optional<Factura> factura = serv.findByID(id);

		if (!factura.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(factura);
	}

	// actualizar Factura
	@PutMapping("/factura/{id}")
	public ResponseEntity<?> actualizarFactura(@RequestBody Factura facturaNuevo, @PathVariable Long id) {
		Optional<Factura> factura = serv.findByID(id);

		if (!factura.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		factura.get().setCliente(facturaNuevo.getCliente());
		factura.get().setFecha(facturaNuevo.getFecha());

		return ResponseEntity.status(HttpStatus.CREATED).body(serv.save(factura.get()));
	}

	// Eliminar factura
	@DeleteMapping("/Factura/{id}")
	public ResponseEntity<?> eliminarFactura(@PathVariable Long id) {

		Optional<Factura> factura = serv.findByID(id);

		if (!factura.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		serv.deleteByID(id);
		return ResponseEntity.ok().build();
	}
}
