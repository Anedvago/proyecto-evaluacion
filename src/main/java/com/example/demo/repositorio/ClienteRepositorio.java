package com.example.demo.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Cliente;


@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
	@Query(nativeQuery = false, value = "SELECT u FROM Cliente u WHERE TIPO_IDENTIFICACION  = :tipo AND IDENTIFICACION = :iden")
	Optional<Cliente> buscarPorIden(@Param("tipo")long tipo,@Param("iden")String iden );
}
