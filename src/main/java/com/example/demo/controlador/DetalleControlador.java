package com.example.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Detalle;
import com.example.demo.modelo.ReporteProd;
import com.example.demo.servicios.DetalleServicio;

@RestController
@RequestMapping("/api/detalles/")
@CrossOrigin("http://localhost:4200/")
public class DetalleControlador {

	@Autowired
	private DetalleServicio serv;

	// lista todos los Detalles
	@GetMapping("/detalles")
	public List<Detalle> listarTodosDetalles() {
		return serv.findAll();
	}

	// crea un nuevo Detalle
	@PostMapping("/registro-detalles")
	public ResponseEntity<Detalle> crearDetalle(@RequestBody Detalle detalle) {
		return ResponseEntity.status(HttpStatus.CREATED).body(serv.save(detalle));
	}

	// Obtener un Detalle
	@GetMapping("/detalle/{id}")
	public ResponseEntity<?> obtenerDetalle(@PathVariable Long id) {
		Optional<Detalle> detalle = serv.findByID(id);

		if (!detalle.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(detalle);
	}

	// actualizar Detalle
	@PutMapping("/detalle/{id}")
	public ResponseEntity<?> actualizarDetalle(@RequestBody Detalle detalleoNuevo, @PathVariable Long id) {
		Optional<Detalle> detalle = serv.findByID(id);

		if (!detalle.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		detalle.get().setCantidad(detalleoNuevo.getCantidad());
		detalle.get().setConsecutivo(detalleoNuevo.getConsecutivo());
		detalle.get().setIdProducto(detalleoNuevo.getIdProducto());
		detalle.get().setValorUnitario(detalleoNuevo.getValorUnitario());

		return ResponseEntity.status(HttpStatus.CREATED).body(serv.save(detalle.get()));
	}

	// Eliminar producto
	@DeleteMapping("/detalle/{id}")
	public ResponseEntity<?> eliminarDetalle(@PathVariable Long id) {

		Optional<Detalle> detalle = serv.findByID(id);

		if (!detalle.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		serv.deleteByID(id);
		return ResponseEntity.ok().build();
	}
	
	//Obtener reporte
	@GetMapping("/reporte-productos")
	public List<ReporteProd> listarReporte() {
		return serv.obtenerReporte();
	}

}
