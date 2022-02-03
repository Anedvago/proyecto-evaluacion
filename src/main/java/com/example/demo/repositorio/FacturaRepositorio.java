package com.example.demo.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Factura;
import com.example.demo.modelo.Usuario;

@Repository
public interface FacturaRepositorio extends JpaRepository<Factura, Long> {
	@Query(nativeQuery = true, value = "SELECT * FROM facturas order by CONSECUTIVO desc limit 1")
	Optional<Factura> obtenerUltFact();
}
