package com.example.demo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "factura_detalle")
public class Detalle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDetalleFactura;
	
	@ManyToOne
	@JoinColumn(name = "CONSECUTIVO")
	private Factura consecutivo;
	
	@ManyToOne()
	@JoinColumn(name = "ID_PRODUCTO")
	private Producto idProducto;
	
	@Column(name = "CANTIDAD")
	private long cantidad;
	
	@Column(name = "VALOR_UNITARIO")
	private long valorUnitario;

	public Detalle() {
		
	}

	public Detalle(long idDetalleFactura, Factura consecutivo, Producto idProducto, long cantidad, long valorUnitario) {
		super();
		this.idDetalleFactura = idDetalleFactura;
		this.consecutivo = consecutivo;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.valorUnitario = valorUnitario;
	}

	public long getIdDetalleFactura() {
		return idDetalleFactura;
	}

	public void setIdDetalleFactura(long idDetalleFactura) {
		this.idDetalleFactura = idDetalleFactura;
	}

	public Factura getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(Factura consecutivo) {
		this.consecutivo = consecutivo;
	}

	public Producto getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Producto idProducto) {
		this.idProducto = idProducto;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	public long getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(long valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	
	
}
