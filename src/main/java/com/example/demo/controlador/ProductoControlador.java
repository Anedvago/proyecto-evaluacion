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

import com.example.demo.modelo.Producto;
import com.example.demo.servicios.ProductoServicio;

@RestController
@RequestMapping("/api/productos/")
public class ProductoControlador {
	@Autowired
	private ProductoServicio serv;

	// lista todos los productos
	@GetMapping("/productos")
	public List<Producto> listarTodosProductos() {
		return serv.findAll();
	}

	// crea un nuevo producto
	@PostMapping("/registro-productos")
	public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(serv.save(producto));
	}

	// Obtener un producto
	@GetMapping("/producto/{id}")
	public ResponseEntity<?> obtenerCliente(@PathVariable Long id) {
		Optional<Producto> producto = serv.findByID(id);

		if (!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(producto);
	}

	// actualizar usuario
	@PutMapping("/producto/{id}")
	public ResponseEntity<?> actualizarProducto(@RequestBody Producto productoNuevo, @PathVariable Long id) {
		Optional<Producto> producto = serv.findByID(id);

		if (!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		producto.get().setEstado(productoNuevo.getEstado());
		producto.get().setNombre(productoNuevo.getNombre());
		producto.get().setValorUnitario(productoNuevo.getValorUnitario());

		return ResponseEntity.status(HttpStatus.CREATED).body(serv.save(producto.get()));
	}

	// Eliminar producto
	@DeleteMapping("/producto/{id}")
	public ResponseEntity<?> eliminarProducto(@PathVariable Long id) {

		Optional<Producto> producto = serv.findByID(id);

		if (!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		serv.deleteByID(id);
		return ResponseEntity.ok().build();
	}
}
