package com.example.demo.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Detalle;
import com.example.demo.modelo.Factura;
import com.example.demo.modelo.ReporteProd;

@Repository
public interface DetalleRepositorio extends JpaRepository<Detalle, Long>{
	
	@Query(nativeQuery = true, value = "select ANY_VALUE(v.id_producto)as codigo, p.nombre,ANY_VALUE(max(v.cantiti))as cantidad,p.VALOR_UNITARIO, v.mes as mes from (SELECT ANY_VALUE(d.ID_PRODUCTO) as id_producto,max(distinct cantidad) as cantiti,sum(d.CANTIDAD) as cantidadAlMes, MONTH(f.FECHA) as mes  FROM factura_detalle as d right join facturas f on d.CONSECUTIVO = f.CONSECUTIVO group by MONTH(f.FECHA),ANY_VALUE(d.ID_PRODUCTO) order by MONTH(f.FECHA),cantidadAlMes desc) as v left join productos as p on v.id_producto = p.ID group by v.mes;")
	List<?> obtenerReporte();

}
