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
	
	@Query(nativeQuery = true, value = "select v.año,ANY_VALUE(v.cliente) as codCliente,ANY_VALUE(c.razon_social) as nombre, ANY_VALUE(max(v.sumaMult))as valor from (select ANY_VALUE(YEAR(f.fecha)) as año ,f.CLIENTE, sum(fd.VALOR_UNITARIO) as valUnit,sum(fd.CANTIDAD) as cant ,ANY_VALUE(fd.VALOR_UNITARIO*fd.CANTIDAD) as mult, sum(fd.VALOR_UNITARIO*fd.CANTIDAD) as sumaMult from facturas as f inner join factura_detalle as fd on f.CONSECUTIVO = fd.CONSECUTIVO group by f.CLIENTE,año order by sumaMult desc) as v left join clientes as c on v.cliente = c.CLIENTE group by v.año;")
	List<?> obtenerReporteClientes();

}
