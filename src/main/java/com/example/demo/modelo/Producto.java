package com.example.demo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {
	
	@Id
	private long id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name = "ESTADO")
	private String estado;
	
	@Column(name="VALOR_UNITARIO")
	private long valorUnitario;

	public Producto() {

	}

	public Producto(long id, String nombre, String estado, long valorUnitario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
		this.valorUnitario = valorUnitario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public long getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(long valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	
	
	
	
}
