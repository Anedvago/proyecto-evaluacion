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
@Table(name="clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cliente;
	
	@ManyToOne
	@JoinColumn(name="TIPO_IDENTIFICACION")
	private TipoIdentificacion tipoIdentificacion;
	
	@Column(name="IDENTIFICACION")
	private String identificacion;
	
	@Column(name="RAZON_SOCIAL")
	private String razonSocial;
	
	@Column(name="FECHA_REGISTRO")
	private Date fechaRegistro;
	
	@Column(name="ESTADO")
	private String estado;

	public Cliente() {
		
	}

	public Cliente(long cliente, TipoIdentificacion tipoIdentificacion, String identificacion, String razonSocial,
			Date fechaRegistro, String estado) {
		super();
		this.cliente = cliente;
		this.tipoIdentificacion = tipoIdentificacion;
		this.identificacion = identificacion;
		this.razonSocial = razonSocial;
		this.fechaRegistro = fechaRegistro;
		this.estado = estado;
	}

	public long getCliente() {
		return cliente;
	}

	public void setCliente(long cliente) {
		this.cliente = cliente;
	}

	public TipoIdentificacion getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	
	

}
