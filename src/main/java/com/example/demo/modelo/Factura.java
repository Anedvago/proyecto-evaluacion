package com.example.demo.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FACTURAS")
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long consecutivo;

	@ManyToOne
	@JoinColumn(name = "CLIENTE")
	private Cliente cliente;

	@Column(name = "FECHA")
	private Date fecha;

	public Factura() {

	}

	public Factura(long consecutivo, Cliente cliente, Date fecha) {
		super();
		this.consecutivo = consecutivo;
		this.cliente = cliente;
		this.fecha = fecha;
	}

	public long getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(long consecutivo) {
		this.consecutivo = consecutivo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
}
